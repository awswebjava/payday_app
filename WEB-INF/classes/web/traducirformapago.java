package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class traducirformapago extends GXProcedure
{
   public traducirformapago( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( traducirformapago.class ), "" );
   }

   public traducirformapago( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              byte[] aP2 ,
                              GXSimpleCollection<String>[] aP3 ,
                              String[] aP4 )
   {
      traducirformapago.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 )
   {
      traducirformapago.this.AV8CliCod = aP0;
      traducirformapago.this.AV12MigrLegFormaPago = aP1;
      traducirformapago.this.aP2 = aP2;
      traducirformapago.this.AV14errores = aP3[0];
      this.aP3 = aP3;
      traducirformapago.this.aP4 = aP4;
      traducirformapago.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug7(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "!!!!!! &MigrLegFormaPago ", "")+GXutil.trim( AV12MigrLegFormaPago)) ;
      GXt_char1 = AV15MigrLegFormaPagoSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( AV12MigrLegFormaPago, GXv_char2) ;
      traducirformapago.this.GXt_char1 = GXv_char2[0] ;
      AV15MigrLegFormaPagoSinAc = GXt_char1 ;
      GXt_char1 = AV15MigrLegFormaPagoSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.defaulttextomigr(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
      traducirformapago.this.GXt_char1 = GXv_char2[0] ;
      AV15MigrLegFormaPagoSinAc = GXutil.strReplace( AV15MigrLegFormaPagoSinAc, GXt_char1, "") ;
      new web.msgdebug7(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&MigrLegFormaPagoSinAc \"", "")+AV15MigrLegFormaPagoSinAc+"\"") ;
      if ( ! (GXutil.strcmp("", AV15MigrLegFormaPagoSinAc)==0) )
      {
         new web.msgdebug7(remoteHandle, context).execute( AV19Pgmname, "1") ;
         AV21GXV2 = 1 ;
         AV20GXV1 = web.gxdomainformadepago.getValues() ;
         while ( AV21GXV2 <= AV20GXV1.size() )
         {
            AV10FormaDePago = ((Number) AV20GXV1.elementAt(-1+AV21GXV2)).byteValue() ;
            new web.msgdebug7(remoteHandle, context).execute( AV19Pgmname, "2") ;
            GXt_char1 = AV16AucMigrLegFormaPago ;
            GXv_char2[0] = GXt_char1 ;
            new web.sacaracentos2(remoteHandle, context).execute( httpContext.getMessage( web.gxdomainformadepago.getDescription(httpContext,(byte)AV10FormaDePago), ""), GXv_char2) ;
            traducirformapago.this.GXt_char1 = GXv_char2[0] ;
            AV16AucMigrLegFormaPago = GXt_char1 ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV16AucMigrLegFormaPago)), GXutil.upper( GXutil.trim( AV15MigrLegFormaPagoSinAc))) == 0 )
            {
               new web.msgdebug7(remoteHandle, context).execute( AV19Pgmname, "3") ;
               AV11LegFormaPago = AV10FormaDePago ;
               AV13encontro = true ;
               if (true) break;
            }
            AV21GXV2 = (int)(AV21GXV2+1) ;
         }
         if ( ! AV13encontro )
         {
            GXt_char1 = AV9error ;
            GXv_char2[0] = GXt_char1 ;
            new web.mensajemigrvalorinvalido(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "Forma de Pago", ""), GXutil.trim( AV15MigrLegFormaPagoSinAc), (short)(1), GXv_char2) ;
            traducirformapago.this.GXt_char1 = GXv_char2[0] ;
            AV9error = GXt_char1 ;
            AV14errores.add(AV9error, 0);
         }
      }
      else
      {
         AV11LegFormaPago = (byte)(0) ;
         new web.msgdebug7(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&LegFormaPago ", "")+GXutil.trim( GXutil.str( AV11LegFormaPago, 1, 0))) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = traducirformapago.this.AV11LegFormaPago;
      this.aP3[0] = traducirformapago.this.AV14errores;
      this.aP4[0] = traducirformapago.this.AV9error;
      this.aP5[0] = traducirformapago.this.AV13encontro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9error = "" ;
      AV19Pgmname = "" ;
      AV15MigrLegFormaPagoSinAc = "" ;
      AV20GXV1 = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV16AucMigrLegFormaPago = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV19Pgmname = "TraducirFormaPago" ;
      /* GeneXus formulas. */
      AV19Pgmname = "TraducirFormaPago" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11LegFormaPago ;
   private byte AV10FormaDePago ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV21GXV2 ;
   private String AV19Pgmname ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV13encontro ;
   private String AV12MigrLegFormaPago ;
   private String AV9error ;
   private String AV15MigrLegFormaPagoSinAc ;
   private String AV16AucMigrLegFormaPago ;
   private GXSimpleCollection<Byte> AV20GXV1 ;
   private boolean[] aP5 ;
   private byte[] aP2 ;
   private GXSimpleCollection<String>[] aP3 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV14errores ;
}

