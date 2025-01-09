package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultsconvenio extends GXProcedure
{
   public defaultsconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultsconvenio.class ), "" );
   }

   public defaultsconvenio( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> executeUdp( String aP0 ,
                                                                                           java.math.BigDecimal[] aP1 ,
                                                                                           boolean[] aP2 ,
                                                                                           java.math.BigDecimal[] aP3 ,
                                                                                           String[] aP4 ,
                                                                                           boolean[] aP5 ,
                                                                                           byte[] aP6 ,
                                                                                           byte[] aP7 ,
                                                                                           short[] aP8 ,
                                                                                           byte[] aP9 ,
                                                                                           byte[] aP10 ,
                                                                                           byte[] aP11 ,
                                                                                           java.util.Date[] aP12 )
   {
      defaultsconvenio.this.aP13 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal[] aP1 ,
                        boolean[] aP2 ,
                        java.math.BigDecimal[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        byte[] aP6 ,
                        byte[] aP7 ,
                        short[] aP8 ,
                        byte[] aP9 ,
                        byte[] aP10 ,
                        byte[] aP11 ,
                        java.util.Date[] aP12 ,
                        GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal[] aP1 ,
                             boolean[] aP2 ,
                             java.math.BigDecimal[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             byte[] aP6 ,
                             byte[] aP7 ,
                             short[] aP8 ,
                             byte[] aP9 ,
                             byte[] aP10 ,
                             byte[] aP11 ,
                             java.util.Date[] aP12 ,
                             GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>[] aP13 )
   {
      defaultsconvenio.this.AV8ConveCodigo = aP0;
      defaultsconvenio.this.aP1 = aP1;
      defaultsconvenio.this.aP2 = aP2;
      defaultsconvenio.this.aP3 = aP3;
      defaultsconvenio.this.aP4 = aP4;
      defaultsconvenio.this.aP5 = aP5;
      defaultsconvenio.this.aP6 = aP6;
      defaultsconvenio.this.aP7 = aP7;
      defaultsconvenio.this.aP8 = aP8;
      defaultsconvenio.this.aP9 = aP9;
      defaultsconvenio.this.aP10 = aP10;
      defaultsconvenio.this.aP11 = aP11;
      defaultsconvenio.this.aP12 = aP12;
      defaultsconvenio.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV16ConveInterDiasJor ;
      GXv_int2[0] = AV17ConveDiasAcuVac ;
      GXv_int3[0] = AV18ConveMinMesesVac ;
      GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4[0] = AV19sdt_conveVacaciones ;
      new web.defaultvacacionesconvenio(remoteHandle, context).execute( GXv_int1, GXv_int2, GXv_int3, GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4) ;
      defaultsconvenio.this.AV16ConveInterDiasJor = GXv_int1[0] ;
      defaultsconvenio.this.AV17ConveDiasAcuVac = GXv_int2[0] ;
      defaultsconvenio.this.AV18ConveMinMesesVac = GXv_int3[0] ;
      AV19sdt_conveVacaciones = GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4[0] ;
      GXt_date5 = AV21CliConveVig ;
      GXv_date6[0] = GXt_date5 ;
      new web.fechadefaultvig(remoteHandle, context).execute( GXv_date6) ;
      defaultsconvenio.this.GXt_date5 = GXv_date6[0] ;
      AV21CliConveVig = GXt_date5 ;
      if ( ( GXutil.strcmp(AV8ConveCodigo, new web.conveniouocra(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(AV8ConveCodigo, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) == 0 ) )
      {
         AV9ConveTopeIndem = DecimalUtil.doubleToDec(2000000) ;
         AV10ConveDefault = true ;
         AV15ConveMesHsPExt = DecimalUtil.doubleToDec(200) ;
         AV14ConveDiaHsPExt = "" ;
         AV13ConveFondoCese = true ;
         AV20ConvePromMeses = (byte)(6) ;
      }
      else if ( GXutil.strcmp(AV8ConveCodigo, new web.conveniouecara(remoteHandle, context).executeUdp( )) == 0 )
      {
         AV9ConveTopeIndem = DecimalUtil.doubleToDec(2000000) ;
         AV10ConveDefault = false ;
         AV15ConveMesHsPExt = DecimalUtil.doubleToDec(200) ;
         AV14ConveDiaHsPExt = "" ;
         AV13ConveFondoCese = false ;
         AV20ConvePromMeses = (byte)(6) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = defaultsconvenio.this.AV9ConveTopeIndem;
      this.aP2[0] = defaultsconvenio.this.AV10ConveDefault;
      this.aP3[0] = defaultsconvenio.this.AV15ConveMesHsPExt;
      this.aP4[0] = defaultsconvenio.this.AV14ConveDiaHsPExt;
      this.aP5[0] = defaultsconvenio.this.AV13ConveFondoCese;
      this.aP6[0] = defaultsconvenio.this.AV12ConvePerVacDes;
      this.aP7[0] = defaultsconvenio.this.AV11ConvePerVacHas;
      this.aP8[0] = defaultsconvenio.this.AV16ConveInterDiasJor;
      this.aP9[0] = defaultsconvenio.this.AV17ConveDiasAcuVac;
      this.aP10[0] = defaultsconvenio.this.AV18ConveMinMesesVac;
      this.aP11[0] = defaultsconvenio.this.AV20ConvePromMeses;
      this.aP12[0] = defaultsconvenio.this.AV21CliConveVig;
      this.aP13[0] = defaultsconvenio.this.AV19sdt_conveVacaciones;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConveTopeIndem = DecimalUtil.ZERO ;
      AV15ConveMesHsPExt = DecimalUtil.ZERO ;
      AV14ConveDiaHsPExt = "" ;
      AV21CliConveVig = GXutil.nullDate() ;
      AV19sdt_conveVacaciones = new GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>(web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem.class, "sdt_conveVacacionesItem", "PayDay", remoteHandle);
      GXv_int1 = new short[1] ;
      GXv_int2 = new byte[1] ;
      GXv_int3 = new byte[1] ;
      GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4 = new GXBaseCollection[1] ;
      GXt_date5 = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12ConvePerVacDes ;
   private byte AV11ConvePerVacHas ;
   private byte AV17ConveDiasAcuVac ;
   private byte AV18ConveMinMesesVac ;
   private byte AV20ConvePromMeses ;
   private byte GXv_int2[] ;
   private byte GXv_int3[] ;
   private short AV16ConveInterDiasJor ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private java.math.BigDecimal AV9ConveTopeIndem ;
   private java.math.BigDecimal AV15ConveMesHsPExt ;
   private String AV8ConveCodigo ;
   private String AV14ConveDiaHsPExt ;
   private java.util.Date AV21CliConveVig ;
   private java.util.Date GXt_date5 ;
   private java.util.Date GXv_date6[] ;
   private boolean AV10ConveDefault ;
   private boolean AV13ConveFondoCese ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>[] aP13 ;
   private java.math.BigDecimal[] aP1 ;
   private boolean[] aP2 ;
   private java.math.BigDecimal[] aP3 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private byte[] aP6 ;
   private byte[] aP7 ;
   private short[] aP8 ;
   private byte[] aP9 ;
   private byte[] aP10 ;
   private byte[] aP11 ;
   private java.util.Date[] aP12 ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> AV19sdt_conveVacaciones ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem4[] ;
}

