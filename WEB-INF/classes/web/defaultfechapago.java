package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultfechapago extends GXProcedure
{
   public defaultfechapago( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultfechapago.class ), "" );
   }

   public defaultfechapago( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     String aP1 ,
                                     java.util.Date aP2 )
   {
      defaultfechapago.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 )
   {
      defaultfechapago.this.AV13CliCod = aP0;
      defaultfechapago.this.AV12TLiqCod = aP1;
      defaultfechapago.this.AV9LiqFecha = aP2;
      defaultfechapago.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV11mensualTLiqCod ;
      GXt_char2 = AV11mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      defaultfechapago.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char2, GXv_char4) ;
      defaultfechapago.this.GXt_char1 = GXv_char4[0] ;
      AV11mensualTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV12TLiqCod, AV11mensualTLiqCod) == 0 )
      {
         AV10LiqFecPago = GXutil.dadd(GXutil.eomdate( AV9LiqFecha),+(1)) ;
      }
      else
      {
         AV10LiqFecPago = localUtil.ymdtod( GXutil.year( AV9LiqFecha), GXutil.month( AV9LiqFecha), 20) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = defaultfechapago.this.AV10LiqFecPago;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqFecPago = GXutil.nullDate() ;
      AV11mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13CliCod ;
   private String AV12TLiqCod ;
   private String AV11mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV9LiqFecha ;
   private java.util.Date AV10LiqFecPago ;
   private java.util.Date[] aP3 ;
}

