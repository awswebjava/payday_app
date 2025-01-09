package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getadelantoanterior extends GXProcedure
{
   public getadelantoanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getadelantoanterior.class ), "" );
   }

   public getadelantoanterior( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 ,
                             String[] aP13 ,
                             int[] aP14 )
   {
      getadelantoanterior.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 ,
                        String[] aP13 ,
                        int[] aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 ,
                             String[] aP13 ,
                             int[] aP14 ,
                             String[] aP15 )
   {
      getadelantoanterior.this.AV8CliCod = aP0;
      getadelantoanterior.this.AV9EmpCod = aP1;
      getadelantoanterior.this.AV10LegNumero = aP2;
      getadelantoanterior.this.AV16LiqPeriodo = aP3;
      getadelantoanterior.this.AV11liqnro = aP4;
      getadelantoanterior.this.AV15SubTipoConCod1 = aP5;
      getadelantoanterior.this.AV27SubTipoConCod2 = aP6;
      getadelantoanterior.this.AV28mesAnterior = aP7;
      getadelantoanterior.this.AV30adelantoTLiqCod = aP8;
      getadelantoanterior.this.aP9 = aP9;
      getadelantoanterior.this.aP10 = aP10;
      getadelantoanterior.this.aP11 = aP11;
      getadelantoanterior.this.aP12 = aP12;
      getadelantoanterior.this.aP13 = aP13;
      getadelantoanterior.this.aP14 = aP14;
      getadelantoanterior.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV12antLiqNro ;
      new web.getliquidacionanteriornosac(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV11liqnro, AV28mesAnterior, AV16LiqPeriodo, GXv_int1) ;
      getadelantoanterior.this.AV12antLiqNro = GXv_int1[0] ;
      AV13novedadesSolo = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&liqnro ", "")+GXutil.trim( GXutil.str( AV11liqnro, 8, 0))+httpContext.getMessage( " 1 &antLiqNro ", "")+GXutil.trim( GXutil.str( AV12antLiqNro, 8, 0))+httpContext.getMessage( " &mesAnterior ", "")+GXutil.trim( GXutil.booltostr( AV28mesAnterior))) ;
      if ( ! (0==AV12antLiqNro) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "asdf", "")) ;
         GXv_decimal2[0] = AV23LiqDImpCalcu ;
         GXv_decimal3[0] = AV24LiqDCanti ;
         GXv_boolean4[0] = false ;
         GXv_int5[0] = (short)(0) ;
         GXv_int6[0] = AV20LiqDCalculado ;
         new web.getimporteporclassubclasytipoliq(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV12antLiqNro, AV15SubTipoConCod1, AV27SubTipoConCod2, AV30adelantoTLiqCod, AV16LiqPeriodo, "Calculo", AV13novedadesSolo, GXv_decimal2, GXv_decimal3, GXv_boolean4, GXv_int5, GXv_int6) ;
         getadelantoanterior.this.AV23LiqDImpCalcu = GXv_decimal2[0] ;
         getadelantoanterior.this.AV24LiqDCanti = GXv_decimal3[0] ;
         getadelantoanterior.this.AV20LiqDCalculado = GXv_int6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&LiqDCanti ", "")+GXutil.trim( GXutil.str( AV24LiqDCanti, 14, 2))) ;
         if ( AV20LiqDCalculado == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, "2") ;
            AV21error = httpContext.getMessage( "NO se pudo calcular cantidad de para clasificación ", "") + GXutil.trim( AV25SubTipoConDes1) + httpContext.getMessage( " de liquidación anterior nro ", "") + GXutil.trim( GXutil.str( AV12antLiqNro, 8, 0)) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = getadelantoanterior.this.AV23LiqDImpCalcu;
      this.aP10[0] = getadelantoanterior.this.AV24LiqDCanti;
      this.aP11[0] = getadelantoanterior.this.AV21error;
      this.aP12[0] = getadelantoanterior.this.AV20LiqDCalculado;
      this.aP13[0] = getadelantoanterior.this.AV22subtipo2Encontrado;
      this.aP14[0] = getadelantoanterior.this.AV12antLiqNro;
      this.aP15[0] = getadelantoanterior.this.AV26encontradoConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23LiqDImpCalcu = DecimalUtil.ZERO ;
      AV24LiqDCanti = DecimalUtil.ZERO ;
      AV21error = "" ;
      AV22subtipo2Encontrado = "" ;
      AV26encontradoConCodigo = "" ;
      GXv_int1 = new int[1] ;
      AV34Pgmname = "" ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_int5 = new short[1] ;
      GXv_int6 = new byte[1] ;
      AV25SubTipoConDes1 = "" ;
      AV34Pgmname = "getAdelantoAnterior" ;
      /* GeneXus formulas. */
      AV34Pgmname = "getAdelantoAnterior" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LiqDCalculado ;
   private byte GXv_int6[] ;
   private short AV9EmpCod ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int AV11liqnro ;
   private int AV12antLiqNro ;
   private int GXv_int1[] ;
   private java.math.BigDecimal AV23LiqDImpCalcu ;
   private java.math.BigDecimal AV24LiqDCanti ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV15SubTipoConCod1 ;
   private String AV27SubTipoConCod2 ;
   private String AV30adelantoTLiqCod ;
   private String AV22subtipo2Encontrado ;
   private String AV26encontradoConCodigo ;
   private String AV34Pgmname ;
   private java.util.Date AV16LiqPeriodo ;
   private boolean AV28mesAnterior ;
   private boolean AV13novedadesSolo ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private String AV21error ;
   private String AV25SubTipoConDes1 ;
   private String[] aP15 ;
   private java.math.BigDecimal[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private byte[] aP12 ;
   private String[] aP13 ;
   private int[] aP14 ;
}

