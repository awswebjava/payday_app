package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class articulo30conaumentoporzona extends GXProcedure
{
   public articulo30conaumentoporzona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articulo30conaumentoporzona.class ), "" );
   }

   public articulo30conaumentoporzona( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      articulo30conaumentoporzona.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 )
   {
      articulo30conaumentoporzona.this.AV10CliCod = aP0;
      articulo30conaumentoporzona.this.AV11EmpCod = aP1;
      articulo30conaumentoporzona.this.AV12LegNumero = aP2;
      articulo30conaumentoporzona.this.AV14LiqPeriodo = aP3;
      articulo30conaumentoporzona.this.AV16idOperando = aP4;
      articulo30conaumentoporzona.this.AV17ProcesoLiquidacion = aP5;
      articulo30conaumentoporzona.this.aP6 = aP6;
      articulo30conaumentoporzona.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_decimal1[0] = AV9ZonPorcAumenDed ;
      new web.getaumentoporzona(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LegNumero, GXv_decimal1) ;
      articulo30conaumentoporzona.this.AV9ZonPorcAumenDed = GXv_decimal1[0] ;
      GXv_decimal1[0] = AV15importes ;
      GXv_char2[0] = AV19auxError ;
      GXv_char3[0] = "" ;
      new web.articulo30(remoteHandle, context).execute( AV10CliCod, AV16idOperando, AV14LiqPeriodo, AV17ProcesoLiquidacion, GXv_decimal1, GXv_char2, GXv_char3) ;
      articulo30conaumentoporzona.this.AV15importes = GXv_decimal1[0] ;
      articulo30conaumentoporzona.this.AV19auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV19auxError)==0) )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV15importes = AV15importes.multiply(AV9ZonPorcAumenDed) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = articulo30conaumentoporzona.this.AV15importes;
      this.aP7[0] = articulo30conaumentoporzona.this.AV19auxError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15importes = DecimalUtil.ZERO ;
      AV19auxError = "" ;
      AV9ZonPorcAumenDed = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_char2 = new String[1] ;
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV15importes ;
   private java.math.BigDecimal AV9ZonPorcAumenDed ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String AV16idOperando ;
   private String AV17ProcesoLiquidacion ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean returnInSub ;
   private String AV19auxError ;
   private String[] aP7 ;
   private java.math.BigDecimal[] aP6 ;
}

