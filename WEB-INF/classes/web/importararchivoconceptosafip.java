package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importararchivoconceptosafip extends GXProcedure
{
   public importararchivoconceptosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importararchivoconceptosafip.class ), "" );
   }

   public importararchivoconceptosafip( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 ,
                              String aP3 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 )
   {
      importararchivoconceptosafip.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ,
                             boolean[] aP5 )
   {
      importararchivoconceptosafip.this.AV9CliCod = aP0;
      importararchivoconceptosafip.this.AV11EmpCod = aP1;
      importararchivoconceptosafip.this.AV14ImpLiqSec = aP2;
      importararchivoconceptosafip.this.AV13ImpLiqConFile = aP3;
      importararchivoconceptosafip.this.aP4 = aP4;
      importararchivoconceptosafip.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18OK = true ;
      AV15importacion_liquidacion.Load(AV9CliCod, AV11EmpCod, AV14ImpLiqSec);
      AV15importacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Clicod( AV9CliCod );
      AV15importacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Empcod( AV11EmpCod );
      AV15importacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Impliqsec( AV14ImpLiqSec );
      AV15importacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Impliqconfile( AV13ImpLiqConFile );
      AV15importacion_liquidacion.Save();
      if ( AV15importacion_liquidacion.Success() )
      {
         GXv_objcol_svchar1[0] = AV21errores1 ;
         GXv_int2[0] = AV8altas ;
         GXv_char3[0] = AV20destino ;
         new web.procesouploadarchafipexterno(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV14ImpLiqSec, GXv_objcol_svchar1, GXv_int2, GXv_char3) ;
         AV21errores1 = GXv_objcol_svchar1[0] ;
         importararchivoconceptosafip.this.AV8altas = GXv_int2[0] ;
         importararchivoconceptosafip.this.AV20destino = GXv_char3[0] ;
         if ( AV21errores1.size() > 0 )
         {
            if ( (GXutil.strcmp("", AV20destino)==0) )
            {
               AV16Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
               AV16Message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "Error inesperado de archivo", "") );
               AV16Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
               AV17Messages.add(AV16Message, 0);
            }
            else
            {
               GXv_objcol_svchar1[0] = AV22errores2 ;
               GXv_int2[0] = AV8altas ;
               new web.procesouploadarchafipexterno_csv(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, AV14ImpLiqSec, AV20destino, GXv_objcol_svchar1, GXv_int2) ;
               AV22errores2 = GXv_objcol_svchar1[0] ;
               importararchivoconceptosafip.this.AV8altas = GXv_int2[0] ;
               if ( AV22errores2.size() > 0 )
               {
                  if ( GXutil.strSearch( (String)AV22errores2.elementAt(-1+1), httpContext.getMessage( "Deberían haber 20 columnas ", ""), 1) != 0 )
                  {
                     AV12errores = AV21errores1 ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "errores 1", "")+AV21errores1.toJSonString(false)) ;
                  }
                  else
                  {
                     AV12errores = AV22errores2 ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "errores 2", "")+AV22errores2.toJSonString(false)) ;
                  }
                  AV18OK = false ;
                  AV10e = (short)(1) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "&errores ", "")+AV12errores.toJSonString(false)) ;
                  while ( AV10e <= AV12errores.size() )
                  {
                     AV16Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
                     AV16Message.setgxTv_SdtMessages_Message_Description( (String)AV12errores.elementAt(-1+AV10e) );
                     AV16Message.setgxTv_SdtMessages_Message_Id( GXutil.trim( GXutil.str( AV10e, 4, 0)) );
                     AV16Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
                     AV17Messages.add(AV16Message, 0);
                     AV10e = (short)(AV10e+1) ;
                  }
                  AV15importacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Impliqconfile( "" );
               }
            }
         }
      }
      else
      {
         AV17Messages = AV15importacion_liquidacion.GetMessages() ;
         AV18OK = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = importararchivoconceptosafip.this.AV17Messages;
      this.aP5[0] = importararchivoconceptosafip.this.AV18OK;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV15importacion_liquidacion = new web.Sdtimportacion_liquidacion(remoteHandle);
      AV21errores1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20destino = "" ;
      GXv_char3 = new String[1] ;
      AV16Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV22errores2 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar1 = new GXSimpleCollection[1] ;
      GXv_int2 = new short[1] ;
      AV12errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25Pgmname = "" ;
      AV25Pgmname = "importarArchivoConceptosAFIP" ;
      /* GeneXus formulas. */
      AV25Pgmname = "importarArchivoConceptosAFIP" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV14ImpLiqSec ;
   private short AV8altas ;
   private short GXv_int2[] ;
   private short AV10e ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String GXv_char3[] ;
   private String AV25Pgmname ;
   private boolean AV18OK ;
   private String AV13ImpLiqConFile ;
   private String AV20destino ;
   private boolean[] aP5 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ;
   private GXSimpleCollection<String> AV21errores1 ;
   private GXSimpleCollection<String> AV22errores2 ;
   private GXSimpleCollection<String> GXv_objcol_svchar1[] ;
   private GXSimpleCollection<String> AV12errores ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV17Messages ;
   private com.genexus.SdtMessages_Message AV16Message ;
   private web.Sdtimportacion_liquidacion AV15importacion_liquidacion ;
}

