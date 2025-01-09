package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpagosacuentaactualizado extends GXProcedure
{
   public getpagosacuentaactualizado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpagosacuentaactualizado.class ), "" );
   }

   public getpagosacuentaactualizado( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           int aP4 ,
                           java.util.Date aP5 ,
                           java.math.BigDecimal[] aP6 )
   {
      getpagosacuentaactualizado.this.aP7 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        byte[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             byte[] aP7 )
   {
      getpagosacuentaactualizado.this.AV11CliCod = aP0;
      getpagosacuentaactualizado.this.AV10EmpCod = aP1;
      getpagosacuentaactualizado.this.AV16LiqNro = aP2;
      getpagosacuentaactualizado.this.AV24LiqRelNro = aP3;
      getpagosacuentaactualizado.this.AV8LegNumero = aP4;
      getpagosacuentaactualizado.this.AV15fecha = aP5;
      getpagosacuentaactualizado.this.aP6 = aP6;
      getpagosacuentaactualizado.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV20PagoACuentaConCodigo ;
      GXt_char2 = AV20PagoACuentaConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getpagosacuentaactualizado.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char2, GXv_char4) ;
      getpagosacuentaactualizado.this.GXt_char1 = GXv_char4[0] ;
      AV20PagoACuentaConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV17LiqDImpReCalcu ;
      new web.getvaloresanterioresactualizados(remoteHandle, context).execute( AV11CliCod, AV10EmpCod, AV16LiqNro, AV24LiqRelNro, AV8LegNumero, AV20PagoACuentaConCodigo, AV15fecha, GXv_decimal5) ;
      getpagosacuentaactualizado.this.AV17LiqDImpReCalcu = GXv_decimal5[0] ;
      AV23pagosACuennta_LiqDImpCalcu = AV23pagosACuennta_LiqDImpCalcu.add(AV17LiqDImpReCalcu) ;
      AV9LiqDImpCalcu = AV23pagosACuennta_LiqDImpCalcu ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getpagosacuentaactualizado.this.AV9LiqDImpCalcu;
      this.aP7[0] = getpagosacuentaactualizado.this.AV14LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LiqDImpCalcu = DecimalUtil.ZERO ;
      AV20PagoACuentaConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV17LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV23pagosACuennta_LiqDImpCalcu = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqDCalculado ;
   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV16LiqNro ;
   private int AV24LiqRelNro ;
   private int AV8LegNumero ;
   private java.math.BigDecimal AV9LiqDImpCalcu ;
   private java.math.BigDecimal AV17LiqDImpReCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV23pagosACuennta_LiqDImpCalcu ;
   private String AV20PagoACuentaConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV15fecha ;
   private byte[] aP7 ;
   private java.math.BigDecimal[] aP6 ;
}

