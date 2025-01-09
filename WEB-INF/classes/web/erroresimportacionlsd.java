package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class erroresimportacionlsd extends GXProcedure
{
   public erroresimportacionlsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( erroresimportacionlsd.class ), "" );
   }

   public erroresimportacionlsd( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short aP2 ,
                            GXSimpleCollection<String>[] aP3 ,
                            short[] aP4 )
   {
      erroresimportacionlsd.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        short[] aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             short[] aP4 ,
                             short[] aP5 )
   {
      erroresimportacionlsd.this.AV11CliCod = aP0;
      erroresimportacionlsd.this.AV10EmpCod = aP1;
      erroresimportacionlsd.this.AV9ImpLiqSec = aP2;
      erroresimportacionlsd.this.aP3 = aP3;
      erroresimportacionlsd.this.aP4 = aP4;
      erroresimportacionlsd.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( false )
      {
         new web.revalidarimplsddet(remoteHandle, context).execute( AV11CliCod, AV10EmpCod, AV9ImpLiqSec) ;
         AV17permiteConfirmar = true ;
         AV20GXLvl4 = (byte)(0) ;
         /* Using cursor P00OJ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Short.valueOf(AV9ImpLiqSec)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            brkOJ2 = false ;
            A713ImpLiqDetConSis = P00OJ2_A713ImpLiqDetConSis[0] ;
            A716ImpLiqDetImpNum = P00OJ2_A716ImpLiqDetImpNum[0] ;
            A709ImpLiqDetError = P00OJ2_A709ImpLiqDetError[0] ;
            A662ImpLiqDetLiqN = P00OJ2_A662ImpLiqDetLiqN[0] ;
            A88ImpLiqSec = P00OJ2_A88ImpLiqSec[0] ;
            A1EmpCod = P00OJ2_A1EmpCod[0] ;
            A3CliCod = P00OJ2_A3CliCod[0] ;
            A90ImpLiqDetSec = P00OJ2_A90ImpLiqDetSec[0] ;
            AV20GXLvl4 = (byte)(1) ;
            AV13cantLiq = (short)(AV13cantLiq+1) ;
            AV14sdt_detalle.clear();
            while ( (pr_default.getStatus(0) != 101) && ( P00OJ2_A3CliCod[0] == A3CliCod ) && ( P00OJ2_A1EmpCod[0] == A1EmpCod ) && ( P00OJ2_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( GXutil.strcmp(P00OJ2_A662ImpLiqDetLiqN[0], A662ImpLiqDetLiqN) == 0 ) )
            {
               brkOJ2 = false ;
               A713ImpLiqDetConSis = P00OJ2_A713ImpLiqDetConSis[0] ;
               A716ImpLiqDetImpNum = P00OJ2_A716ImpLiqDetImpNum[0] ;
               A709ImpLiqDetError = P00OJ2_A709ImpLiqDetError[0] ;
               A90ImpLiqDetSec = P00OJ2_A90ImpLiqDetSec[0] ;
               AV16item = (web.Sdtsdt_detalle_sdt_detalleItem)new web.Sdtsdt_detalle_sdt_detalleItem(remoteHandle, context);
               AV16item.setgxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo( A713ImpLiqDetConSis );
               AV16item.setgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado( false );
               AV16item.setgxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu( A716ImpLiqDetImpNum );
               AV14sdt_detalle.add(AV16item, 0);
               if ( ! (GXutil.strcmp("", A709ImpLiqDetError)==0) && ( GXutil.strSearch( A709ImpLiqDetError, httpContext.getMessage( "No existe legajo con CUIL", ""), 1) == 0 ) )
               {
                  AV8errores.add(A709ImpLiqDetError, 0);
               }
               AV12cant = (short)(AV12cant+1) ;
               brkOJ2 = true ;
               pr_default.readNext(0);
            }
            GXv_boolean1[0] = AV15duplicaEs ;
            new web.validarliquidacionduplicada(remoteHandle, context).execute( AV11CliCod, AV10EmpCod, AV14sdt_detalle, GXv_boolean1) ;
            erroresimportacionlsd.this.AV15duplicaEs = GXv_boolean1[0] ;
            if ( AV15duplicaEs )
            {
               AV8errores.add(httpContext.getMessage( "La liquidación duplica con una existente", ""), 0);
            }
            if ( ! brkOJ2 )
            {
               brkOJ2 = true ;
               pr_default.readNext(0);
            }
         }
         pr_default.close(0);
         if ( AV20GXLvl4 == 0 )
         {
            AV8errores.add(httpContext.getMessage( "No hay liquidaciones para importar. Debe cargar archivos de LSD", ""), 0);
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = erroresimportacionlsd.this.AV8errores;
      this.aP4[0] = erroresimportacionlsd.this.AV12cant;
      this.aP5[0] = erroresimportacionlsd.this.AV13cantLiq;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8errores = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P00OJ2_A713ImpLiqDetConSis = new String[] {""} ;
      P00OJ2_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OJ2_A709ImpLiqDetError = new String[] {""} ;
      P00OJ2_A662ImpLiqDetLiqN = new String[] {""} ;
      P00OJ2_A88ImpLiqSec = new short[1] ;
      P00OJ2_A1EmpCod = new short[1] ;
      P00OJ2_A3CliCod = new int[1] ;
      P00OJ2_A90ImpLiqDetSec = new short[1] ;
      A713ImpLiqDetConSis = "" ;
      A716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      A709ImpLiqDetError = "" ;
      A662ImpLiqDetLiqN = "" ;
      AV14sdt_detalle = new GXBaseCollection<web.Sdtsdt_detalle_sdt_detalleItem>(web.Sdtsdt_detalle_sdt_detalleItem.class, "sdt_detalleItem", "PayDay", remoteHandle);
      AV16item = new web.Sdtsdt_detalle_sdt_detalleItem(remoteHandle, context);
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.erroresimportacionlsd__default(),
         new Object[] {
             new Object[] {
            P00OJ2_A713ImpLiqDetConSis, P00OJ2_A716ImpLiqDetImpNum, P00OJ2_A709ImpLiqDetError, P00OJ2_A662ImpLiqDetLiqN, P00OJ2_A88ImpLiqSec, P00OJ2_A1EmpCod, P00OJ2_A3CliCod, P00OJ2_A90ImpLiqDetSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV20GXLvl4 ;
   private short AV10EmpCod ;
   private short AV9ImpLiqSec ;
   private short AV12cant ;
   private short AV13cantLiq ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A90ImpLiqDetSec ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal A716ImpLiqDetImpNum ;
   private String scmdbuf ;
   private String A713ImpLiqDetConSis ;
   private String A662ImpLiqDetLiqN ;
   private boolean AV17permiteConfirmar ;
   private boolean brkOJ2 ;
   private boolean AV15duplicaEs ;
   private boolean GXv_boolean1[] ;
   private String A709ImpLiqDetError ;
   private short[] aP5 ;
   private GXSimpleCollection<String>[] aP3 ;
   private short[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00OJ2_A713ImpLiqDetConSis ;
   private java.math.BigDecimal[] P00OJ2_A716ImpLiqDetImpNum ;
   private String[] P00OJ2_A709ImpLiqDetError ;
   private String[] P00OJ2_A662ImpLiqDetLiqN ;
   private short[] P00OJ2_A88ImpLiqSec ;
   private short[] P00OJ2_A1EmpCod ;
   private int[] P00OJ2_A3CliCod ;
   private short[] P00OJ2_A90ImpLiqDetSec ;
   private GXSimpleCollection<String> AV8errores ;
   private GXBaseCollection<web.Sdtsdt_detalle_sdt_detalleItem> AV14sdt_detalle ;
   private web.Sdtsdt_detalle_sdt_detalleItem AV16item ;
}

final  class erroresimportacionlsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OJ2", "SELECT ImpLiqDetConSis, ImpLiqDetImpNum, ImpLiqDetError, ImpLiqDetLiqN, ImpLiqSec, EmpCod, CliCod, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetLiqN ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

