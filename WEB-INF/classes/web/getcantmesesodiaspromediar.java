package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcantmesesodiaspromediar extends GXProcedure
{
   public getcantmesesodiaspromediar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcantmesesodiaspromediar.class ), "" );
   }

   public getcantmesesodiaspromediar( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtbase_promedio_base_promedioItem> executeUdp( int aP0 ,
                                                                               short aP1 ,
                                                                               int aP2 ,
                                                                               int aP3 ,
                                                                               byte aP4 ,
                                                                               String aP5 ,
                                                                               String aP6 ,
                                                                               String aP7 ,
                                                                               short[] aP8 ,
                                                                               short[] aP9 ,
                                                                               String[] aP10 )
   {
      getcantmesesodiaspromediar.this.aP11 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        short[] aP8 ,
                        short[] aP9 ,
                        String[] aP10 ,
                        GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             short[] aP8 ,
                             short[] aP9 ,
                             String[] aP10 ,
                             GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>[] aP11 )
   {
      getcantmesesodiaspromediar.this.AV8CliCod = aP0;
      getcantmesesodiaspromediar.this.AV9EmpCod = aP1;
      getcantmesesodiaspromediar.this.AV32LiqNro = aP2;
      getcantmesesodiaspromediar.this.AV21LegNumero = aP3;
      getcantmesesodiaspromediar.this.AV10EmpBaseClaseLeg = aP4;
      getcantmesesodiaspromediar.this.AV11EmpBaseTipo = aP5;
      getcantmesesodiaspromediar.this.AV12EmpBaseCod1 = aP6;
      getcantmesesodiaspromediar.this.AV13EmpBaseCod2 = aP7;
      getcantmesesodiaspromediar.this.aP8 = aP8;
      getcantmesesodiaspromediar.this.aP9 = aP9;
      getcantmesesodiaspromediar.this.aP10 = aP10;
      getcantmesesodiaspromediar.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV22PaiCod ;
      new web.empresagetpais(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, GXv_int1) ;
      getcantmesesodiaspromediar.this.AV22PaiCod = GXv_int1[0] ;
      GXv_char2[0] = AV23ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV21LegNumero, GXv_char2) ;
      getcantmesesodiaspromediar.this.AV23ConveCodigo = GXv_char2[0] ;
      GXv_char2[0] = AV31tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV32LiqNro, AV21LegNumero, (short)(0), "", "", GXv_char2) ;
      getcantmesesodiaspromediar.this.AV31tipo_tarifa = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV23ConveCodigo)==0) )
      {
         GXv_int3[0] = AV24CliConveVer ;
         new web.getversionconvenio(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV21LegNumero, AV22PaiCod, AV23ConveCodigo, GXv_int3) ;
         getcantmesesodiaspromediar.this.AV24CliConveVer = GXv_int3[0] ;
         GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
         GXv_int1[0] = AV20cant1 ;
         GXv_int5[0] = AV19cant2 ;
         GXv_char2[0] = AV18duracion_tipo ;
         GXv_boolean6[0] = AV28hay ;
         new web.getconvebasedatosremu(remoteHandle, context).execute( AV24CliConveVer, AV22PaiCod, AV23ConveCodigo, AV31tipo_tarifa, AV11EmpBaseTipo, AV12EmpBaseCod1, AV13EmpBaseCod2, GXv_decimal4, GXv_int1, GXv_int5, GXv_char2, GXv_boolean6) ;
         getcantmesesodiaspromediar.this.AV20cant1 = GXv_int1[0] ;
         getcantmesesodiaspromediar.this.AV19cant2 = GXv_int5[0] ;
         getcantmesesodiaspromediar.this.AV18duracion_tipo = GXv_char2[0] ;
         getcantmesesodiaspromediar.this.AV28hay = GXv_boolean6[0] ;
      }
      if ( ! AV28hay )
      {
         GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
         GXv_int5[0] = AV20cant1 ;
         GXv_int1[0] = AV19cant2 ;
         GXv_char2[0] = AV18duracion_tipo ;
         GXv_boolean6[0] = AV28hay ;
         new web.getempbasedatosremu(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV31tipo_tarifa, AV11EmpBaseTipo, AV12EmpBaseCod1, AV13EmpBaseCod2, GXv_decimal4, GXv_int5, GXv_int1, GXv_char2, GXv_boolean6) ;
         getcantmesesodiaspromediar.this.AV20cant1 = GXv_int5[0] ;
         getcantmesesodiaspromediar.this.AV19cant2 = GXv_int1[0] ;
         getcantmesesodiaspromediar.this.AV18duracion_tipo = GXv_char2[0] ;
         getcantmesesodiaspromediar.this.AV28hay = GXv_boolean6[0] ;
      }
      else
      {
      }
      if ( ! AV28hay )
      {
         GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
         GXv_int5[0] = AV20cant1 ;
         GXv_int1[0] = AV19cant2 ;
         GXv_char2[0] = AV18duracion_tipo ;
         GXv_boolean6[0] = AV28hay ;
         new web.getpaibasedatosremu(remoteHandle, context).execute( AV22PaiCod, AV31tipo_tarifa, AV11EmpBaseTipo, AV12EmpBaseCod1, AV13EmpBaseCod2, GXv_decimal4, GXv_int5, GXv_int1, GXv_char2, GXv_boolean6) ;
         getcantmesesodiaspromediar.this.AV20cant1 = GXv_int5[0] ;
         getcantmesesodiaspromediar.this.AV19cant2 = GXv_int1[0] ;
         getcantmesesodiaspromediar.this.AV18duracion_tipo = GXv_char2[0] ;
         getcantmesesodiaspromediar.this.AV28hay = GXv_boolean6[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&PaiCod: ", "")+GXutil.trim( GXutil.str( AV22PaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV21LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&ConveCodigo: ", "")+GXutil.trim( AV23ConveCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&CliConveVer: ", "")+GXutil.trim( GXutil.str( AV24CliConveVer, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&EmpBaseClaseLeg: ", "")+GXutil.trim( GXutil.str( AV10EmpBaseClaseLeg, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&EmpBaseTipo: ", "")+GXutil.trim( AV11EmpBaseTipo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&EmpBaseCod1: ", "")+GXutil.trim( AV12EmpBaseCod1)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&EmpBaseCod2: ", "")+GXutil.trim( AV13EmpBaseCod2)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&cant1: ", "")+GXutil.trim( GXutil.str( AV20cant1, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&cant2: ", "")+GXutil.trim( GXutil.str( AV19cant2, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&duracion_tipo: ", "")+GXutil.trim( AV18duracion_tipo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "&hay: ", "")+GXutil.trim( GXutil.booltostr( AV28hay))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getcantmesesodiaspromediar.this.AV20cant1;
      this.aP9[0] = getcantmesesodiaspromediar.this.AV19cant2;
      this.aP10[0] = getcantmesesodiaspromediar.this.AV18duracion_tipo;
      this.aP11[0] = getcantmesesodiaspromediar.this.AV29base_promedio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18duracion_tipo = "" ;
      AV29base_promedio = new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>(web.Sdtbase_promedio_base_promedioItem.class, "base_promedioItem", "PayDay", remoteHandle);
      AV23ConveCodigo = "" ;
      AV31tipo_tarifa = "" ;
      GXv_int3 = new int[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_int5 = new short[1] ;
      GXv_int1 = new short[1] ;
      GXv_char2 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV35Pgmname = "" ;
      AV35Pgmname = "getCantMesesODiasPromediar" ;
      /* GeneXus formulas. */
      AV35Pgmname = "getCantMesesODiasPromediar" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10EmpBaseClaseLeg ;
   private short AV9EmpCod ;
   private short AV20cant1 ;
   private short AV19cant2 ;
   private short AV22PaiCod ;
   private short GXv_int5[] ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV32LiqNro ;
   private int AV21LegNumero ;
   private int AV24CliConveVer ;
   private int GXv_int3[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV11EmpBaseTipo ;
   private String AV12EmpBaseCod1 ;
   private String AV13EmpBaseCod2 ;
   private String AV18duracion_tipo ;
   private String AV23ConveCodigo ;
   private String AV31tipo_tarifa ;
   private String GXv_char2[] ;
   private String AV35Pgmname ;
   private boolean AV28hay ;
   private boolean GXv_boolean6[] ;
   private GXBaseCollection<web.Sdtbase_promedio_base_promedioItem>[] aP11 ;
   private short[] aP8 ;
   private short[] aP9 ;
   private String[] aP10 ;
   private GXBaseCollection<web.Sdtbase_promedio_base_promedioItem> AV29base_promedio ;
}

