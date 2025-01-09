package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class generarauxiliaresliqsimportadas extends GXProcedure
{
   public generarauxiliaresliqsimportadas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( generarauxiliaresliqsimportadas.class ), "" );
   }

   public generarauxiliaresliqsimportadas( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem> aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem> aP2 )
   {
      generarauxiliaresliqsimportadas.this.AV8CliCod = aP0;
      generarauxiliaresliqsimportadas.this.AV10EmpCod = aP1;
      generarauxiliaresliqsimportadas.this.AV12importacion_sdt = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&importacion_sdt count ", "")+GXutil.trim( GXutil.str( AV12importacion_sdt.size(), 9, 0))+httpContext.getMessage( " json ", "")+AV12importacion_sdt.toJSonString(false)) ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV12importacion_sdt.size() )
      {
         AV13item = (web.Sdtimportacion_sdt_importacion_sdtItem)((web.Sdtimportacion_sdt_importacion_sdtItem)AV12importacion_sdt.elementAt(-1+AV20GXV1));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&item.LiqNro ", "")+GXutil.trim( GXutil.str( AV13item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro(), 8, 0))) ;
         if ( AV13item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro() > 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&item.Legajos ", "")+GXutil.trim( GXutil.str( AV13item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size(), 9, 0))) ;
            AV9collection_LegNumero.clear();
            AV21GXV2 = 1 ;
            while ( AV21GXV2 <= AV13item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().size() )
            {
               AV16legajoItemin = (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)((web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)AV13item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().elementAt(-1+AV21GXV2));
               AV9collection_LegNumero.add((int)(AV15legajoItem.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero()), 0);
               AV21GXV2 = (int)(AV21GXV2+1) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "llama a procesos &collection_LegNumero ", "")+GXutil.trim( GXutil.str( AV9collection_LegNumero.size(), 9, 0))) ;
            new web.procesossegundoplano(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV13item.getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro(), AV9collection_LegNumero, "", true) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "despues de procesos", "")) ;
         }
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Pgmname = "" ;
      AV13item = new web.Sdtimportacion_sdt_importacion_sdtItem(remoteHandle, context);
      AV9collection_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV16legajoItemin = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
      AV15legajoItem = new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(remoteHandle, context);
      AV19Pgmname = "generarAuxiliaresLiqsImportadas" ;
      /* GeneXus formulas. */
      AV19Pgmname = "generarAuxiliaresLiqsImportadas" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV20GXV1 ;
   private int AV21GXV2 ;
   private String AV19Pgmname ;
   private GXSimpleCollection<Integer> AV9collection_LegNumero ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem AV15legajoItem ;
   private GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem> AV12importacion_sdt ;
   private web.Sdtimportacion_sdt_importacion_sdtItem AV13item ;
   private web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem AV16legajoItemin ;
}

