package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getplusdebasedecalculo extends GXProcedure
{
   public getplusdebasedecalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getplusdebasedecalculo.class ), "" );
   }

   public getplusdebasedecalculo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           short aP4 ,
                                           String aP5 ,
                                           byte aP6 ,
                                           String aP7 ,
                                           String aP8 ,
                                           String aP9 )
   {
      getplusdebasedecalculo.this.aP10 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        java.math.BigDecimal[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 )
   {
      getplusdebasedecalculo.this.AV19CliCod = aP0;
      getplusdebasedecalculo.this.AV20EmpCod = aP1;
      getplusdebasedecalculo.this.AV24LiqNro = aP2;
      getplusdebasedecalculo.this.AV22LegNumero = aP3;
      getplusdebasedecalculo.this.AV8PaiCod = aP4;
      getplusdebasedecalculo.this.AV9ConveCodigo = aP5;
      getplusdebasedecalculo.this.AV11ClaseLeg = aP6;
      getplusdebasedecalculo.this.AV12tipo_base = aP7;
      getplusdebasedecalculo.this.AV13codigo1 = aP8;
      getplusdebasedecalculo.this.AV14codigo2 = aP9;
      getplusdebasedecalculo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV23tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV19CliCod, AV20EmpCod, AV24LiqNro, AV22LegNumero, (short)(0), "", "", GXv_char1) ;
      getplusdebasedecalculo.this.AV23tipo_tarifa = GXv_char1[0] ;
      GXv_int2[0] = AV21CliConveVer ;
      new web.getversionconvenio(remoteHandle, context).execute( AV19CliCod, AV20EmpCod, AV22LegNumero, AV8PaiCod, AV9ConveCodigo, GXv_int2) ;
      getplusdebasedecalculo.this.AV21CliConveVer = GXv_int2[0] ;
      GXv_decimal3[0] = AV16LiqDPlus ;
      GXv_int4[0] = (short)(0) ;
      GXv_int5[0] = (short)(0) ;
      GXv_char1[0] = "meses" ;
      GXv_boolean6[0] = AV17hay ;
      new web.getconvebasedatosremu(remoteHandle, context).execute( AV21CliConveVer, AV8PaiCod, AV9ConveCodigo, AV23tipo_tarifa, AV12tipo_base, AV13codigo1, AV14codigo2, GXv_decimal3, GXv_int4, GXv_int5, GXv_char1, GXv_boolean6) ;
      getplusdebasedecalculo.this.AV16LiqDPlus = GXv_decimal3[0] ;
      getplusdebasedecalculo.this.AV17hay = GXv_boolean6[0] ;
      if ( ! AV17hay )
      {
         GXv_decimal3[0] = AV16LiqDPlus ;
         GXv_int5[0] = (short)(0) ;
         GXv_int4[0] = (short)(0) ;
         GXv_char1[0] = "meses" ;
         GXv_boolean6[0] = AV17hay ;
         new web.getempbasedatosremu(remoteHandle, context).execute( AV19CliCod, AV20EmpCod, AV23tipo_tarifa, AV12tipo_base, AV13codigo1, AV14codigo2, GXv_decimal3, GXv_int5, GXv_int4, GXv_char1, GXv_boolean6) ;
         getplusdebasedecalculo.this.AV16LiqDPlus = GXv_decimal3[0] ;
         getplusdebasedecalculo.this.AV17hay = GXv_boolean6[0] ;
      }
      if ( ! AV17hay )
      {
         GXv_decimal3[0] = AV16LiqDPlus ;
         GXv_int5[0] = (short)(0) ;
         GXv_int4[0] = (short)(0) ;
         GXv_char1[0] = "meses" ;
         GXv_boolean6[0] = AV17hay ;
         new web.getpaibasedatosremu(remoteHandle, context).execute( AV8PaiCod, AV23tipo_tarifa, AV12tipo_base, AV13codigo1, AV14codigo2, GXv_decimal3, GXv_int5, GXv_int4, GXv_char1, GXv_boolean6) ;
         getplusdebasedecalculo.this.AV16LiqDPlus = GXv_decimal3[0] ;
         getplusdebasedecalculo.this.AV17hay = GXv_boolean6[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = getplusdebasedecalculo.this.AV16LiqDPlus;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16LiqDPlus = DecimalUtil.ZERO ;
      AV23tipo_tarifa = "" ;
      GXv_int2 = new int[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_int5 = new short[1] ;
      GXv_int4 = new short[1] ;
      GXv_char1 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11ClaseLeg ;
   private short AV20EmpCod ;
   private short AV8PaiCod ;
   private short GXv_int5[] ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV24LiqNro ;
   private int AV22LegNumero ;
   private int AV21CliConveVer ;
   private int GXv_int2[] ;
   private java.math.BigDecimal AV16LiqDPlus ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV9ConveCodigo ;
   private String AV12tipo_base ;
   private String AV13codigo1 ;
   private String AV14codigo2 ;
   private String AV23tipo_tarifa ;
   private String GXv_char1[] ;
   private boolean AV17hay ;
   private boolean GXv_boolean6[] ;
   private java.math.BigDecimal[] aP10 ;
}

