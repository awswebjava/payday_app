package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sueldo_bruto_promedio extends GXProcedure
{
   public sueldo_bruto_promedio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sueldo_bruto_promedio.class ), "" );
   }

   public sueldo_bruto_promedio( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 )
   {
      sueldo_bruto_promedio.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        java.util.Date aP7 ,
                        String aP8 ,
                        String aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        byte[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 ,
                             String[] aP12 )
   {
      sueldo_bruto_promedio.this.AV11CliCod = aP0;
      sueldo_bruto_promedio.this.AV12EmpCod = aP1;
      sueldo_bruto_promedio.this.AV20LiqNro = aP2;
      sueldo_bruto_promedio.this.AV29LiqRelNro = aP3;
      sueldo_bruto_promedio.this.AV13LegNumero = aP4;
      sueldo_bruto_promedio.this.AV27LiqPeriodo = aP5;
      sueldo_bruto_promedio.this.AV24desdeFecha = aP6;
      sueldo_bruto_promedio.this.AV26parmHastaFecha = aP7;
      sueldo_bruto_promedio.this.AV23ConCodigo = aP8;
      sueldo_bruto_promedio.this.AV15ProcesoLiquidacion = aP9;
      sueldo_bruto_promedio.this.aP10 = aP10;
      sueldo_bruto_promedio.this.aP11 = aP11;
      sueldo_bruto_promedio.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV26parmHastaFecha)) )
      {
         AV25hastaFecha = localUtil.ymdtod( GXutil.year( AV27LiqPeriodo), 12, 1) ;
      }
      else
      {
         AV25hastaFecha = AV26parmHastaFecha ;
      }
      GXt_char1 = AV14RembrutaConCodigo ;
      GXt_char2 = AV14RembrutaConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      sueldo_bruto_promedio.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char2, GXv_char4) ;
      sueldo_bruto_promedio.this.GXt_char1 = GXv_char4[0] ;
      AV14RembrutaConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV16LiqDImpCalcu ;
      GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
      GXv_boolean7[0] = false ;
      GXv_int8[0] = AV17cantPeriodos ;
      GXv_int9[0] = AV18LiqDCalculado ;
      GXv_boolean10[0] = false ;
      GXv_char4[0] = AV22error ;
      new web.getliqdimpcalcuacumulado3(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV20LiqNro, AV29LiqRelNro, AV13LegNumero, AV14RembrutaConCodigo, AV28ConceptoTipo, AV24desdeFecha, AV25hastaFecha, AV23ConCodigo, AV15ProcesoLiquidacion, false, true, "", true, "", GXv_decimal5, GXv_decimal6, GXv_boolean7, GXv_int8, GXv_int9, GXv_boolean10, GXv_char4) ;
      sueldo_bruto_promedio.this.AV16LiqDImpCalcu = GXv_decimal5[0] ;
      sueldo_bruto_promedio.this.AV17cantPeriodos = GXv_int8[0] ;
      sueldo_bruto_promedio.this.AV18LiqDCalculado = GXv_int9[0] ;
      sueldo_bruto_promedio.this.AV22error = GXv_char4[0] ;
      if ( AV18LiqDCalculado == 0 )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         if ( AV17cantPeriodos > 0 )
         {
            AV19brutoPromedio = AV16LiqDImpCalcu.divide(DecimalUtil.doubleToDec(AV17cantPeriodos), 18, java.math.RoundingMode.DOWN) ;
         }
         else
         {
            AV19brutoPromedio = AV16LiqDImpCalcu ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = sueldo_bruto_promedio.this.AV19brutoPromedio;
      this.aP11[0] = sueldo_bruto_promedio.this.AV18LiqDCalculado;
      this.aP12[0] = sueldo_bruto_promedio.this.AV22error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19brutoPromedio = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV25hastaFecha = GXutil.nullDate() ;
      AV14RembrutaConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV28ConceptoTipo = "" ;
      AV16LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_int8 = new short[1] ;
      GXv_int9 = new byte[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18LiqDCalculado ;
   private byte GXv_int9[] ;
   private short AV12EmpCod ;
   private short AV17cantPeriodos ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV20LiqNro ;
   private int AV29LiqRelNro ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV19brutoPromedio ;
   private java.math.BigDecimal AV16LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV23ConCodigo ;
   private String AV15ProcesoLiquidacion ;
   private String AV14RembrutaConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String AV28ConceptoTipo ;
   private String GXv_char4[] ;
   private java.util.Date AV27LiqPeriodo ;
   private java.util.Date AV24desdeFecha ;
   private java.util.Date AV26parmHastaFecha ;
   private java.util.Date AV25hastaFecha ;
   private boolean GXv_boolean7[] ;
   private boolean GXv_boolean10[] ;
   private boolean returnInSub ;
   private String AV22error ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP10 ;
   private byte[] aP11 ;
}

