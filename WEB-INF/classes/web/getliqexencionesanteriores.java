package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqexencionesanteriores extends GXProcedure
{
   public getliqexencionesanteriores( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqexencionesanteriores.class ), "" );
   }

   public getliqexencionesanteriores( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           short aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           short aP5 ,
                                           String aP6 ,
                                           String aP7 )
   {
      getliqexencionesanteriores.this.aP8 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        short aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             short aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 )
   {
      getliqexencionesanteriores.this.AV11CliCod = aP0;
      getliqexencionesanteriores.this.AV12EmpCod = aP1;
      getliqexencionesanteriores.this.AV13LiqExAnio = aP2;
      getliqexencionesanteriores.this.AV9LiqNro = aP3;
      getliqexencionesanteriores.this.AV14LegNumero = aP4;
      getliqexencionesanteriores.this.AV15LiqExAplIIGG = aP5;
      getliqexencionesanteriores.this.AV8LiqExenConCodigo = aP6;
      getliqexencionesanteriores.this.AV16idOperando = aP7;
      getliqexencionesanteriores.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV16idOperando)==0) )
      {
         /* Using cursor P017O2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV13LiqExAnio), Integer.valueOf(AV14LegNumero), Short.valueOf(AV15LiqExAplIIGG)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1128LiqExAplIIGG = P017O2_A1128LiqExAplIIGG[0] ;
            A6LegNumero = P017O2_A6LegNumero[0] ;
            A1129LiqExAnio = P017O2_A1129LiqExAnio[0] ;
            A1EmpCod = P017O2_A1EmpCod[0] ;
            A3CliCod = P017O2_A3CliCod[0] ;
            A31LiqNro = P017O2_A31LiqNro[0] ;
            A1127LiqExenConCodigo = P017O2_A1127LiqExenConCodigo[0] ;
            A1126LiqExenImp = P017O2_A1126LiqExenImp[0] ;
            if ( ( GXutil.strcmp(A1127LiqExenConCodigo, AV8LiqExenConCodigo) != 0 ) && ( A31LiqNro < AV9LiqNro ) )
            {
               AV10LiqExenImp = AV10LiqExenImp.add(A1126LiqExenImp) ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P017O3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV13LiqExAnio), Integer.valueOf(AV14LegNumero), Short.valueOf(AV15LiqExAplIIGG), Integer.valueOf(AV9LiqNro)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A31LiqNro = P017O3_A31LiqNro[0] ;
            A1128LiqExAplIIGG = P017O3_A1128LiqExAplIIGG[0] ;
            A6LegNumero = P017O3_A6LegNumero[0] ;
            A1129LiqExAnio = P017O3_A1129LiqExAnio[0] ;
            A1EmpCod = P017O3_A1EmpCod[0] ;
            A3CliCod = P017O3_A3CliCod[0] ;
            A1127LiqExenConCodigo = P017O3_A1127LiqExenConCodigo[0] ;
            A1126LiqExenImp = P017O3_A1126LiqExenImp[0] ;
            if ( ( ( A31LiqNro <= AV9LiqNro ) && ( GXutil.strcmp(A1127LiqExenConCodigo, AV8LiqExenConCodigo) != 0 ) ) || ( ( A31LiqNro < AV9LiqNro ) && ( GXutil.strcmp(A1127LiqExenConCodigo, AV8LiqExenConCodigo) == 0 ) ) )
            {
               AV10LiqExenImp = AV10LiqExenImp.add(A1126LiqExenImp) ;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getliqexencionesanteriores.this.AV10LiqExenImp;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqExenImp = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P017O2_A1128LiqExAplIIGG = new short[1] ;
      P017O2_A6LegNumero = new int[1] ;
      P017O2_A1129LiqExAnio = new short[1] ;
      P017O2_A1EmpCod = new short[1] ;
      P017O2_A3CliCod = new int[1] ;
      P017O2_A31LiqNro = new int[1] ;
      P017O2_A1127LiqExenConCodigo = new String[] {""} ;
      P017O2_A1126LiqExenImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1127LiqExenConCodigo = "" ;
      A1126LiqExenImp = DecimalUtil.ZERO ;
      P017O3_A31LiqNro = new int[1] ;
      P017O3_A1128LiqExAplIIGG = new short[1] ;
      P017O3_A6LegNumero = new int[1] ;
      P017O3_A1129LiqExAnio = new short[1] ;
      P017O3_A1EmpCod = new short[1] ;
      P017O3_A3CliCod = new int[1] ;
      P017O3_A1127LiqExenConCodigo = new String[] {""} ;
      P017O3_A1126LiqExenImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqexencionesanteriores__default(),
         new Object[] {
             new Object[] {
            P017O2_A1128LiqExAplIIGG, P017O2_A6LegNumero, P017O2_A1129LiqExAnio, P017O2_A1EmpCod, P017O2_A3CliCod, P017O2_A31LiqNro, P017O2_A1127LiqExenConCodigo, P017O2_A1126LiqExenImp
            }
            , new Object[] {
            P017O3_A31LiqNro, P017O3_A1128LiqExAplIIGG, P017O3_A6LegNumero, P017O3_A1129LiqExAnio, P017O3_A1EmpCod, P017O3_A3CliCod, P017O3_A1127LiqExenConCodigo, P017O3_A1126LiqExenImp
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV13LiqExAnio ;
   private short AV15LiqExAplIIGG ;
   private short A1128LiqExAplIIGG ;
   private short A1129LiqExAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int AV14LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private java.math.BigDecimal AV10LiqExenImp ;
   private java.math.BigDecimal A1126LiqExenImp ;
   private String AV8LiqExenConCodigo ;
   private String AV16idOperando ;
   private String scmdbuf ;
   private String A1127LiqExenConCodigo ;
   private java.math.BigDecimal[] aP8 ;
   private IDataStoreProvider pr_default ;
   private short[] P017O2_A1128LiqExAplIIGG ;
   private int[] P017O2_A6LegNumero ;
   private short[] P017O2_A1129LiqExAnio ;
   private short[] P017O2_A1EmpCod ;
   private int[] P017O2_A3CliCod ;
   private int[] P017O2_A31LiqNro ;
   private String[] P017O2_A1127LiqExenConCodigo ;
   private java.math.BigDecimal[] P017O2_A1126LiqExenImp ;
   private int[] P017O3_A31LiqNro ;
   private short[] P017O3_A1128LiqExAplIIGG ;
   private int[] P017O3_A6LegNumero ;
   private short[] P017O3_A1129LiqExAnio ;
   private short[] P017O3_A1EmpCod ;
   private int[] P017O3_A3CliCod ;
   private String[] P017O3_A1127LiqExenConCodigo ;
   private java.math.BigDecimal[] P017O3_A1126LiqExenImp ;
}

final  class getliqexencionesanteriores__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017O2", "SELECT LiqExAplIIGG, LegNumero, LiqExAnio, EmpCod, CliCod, LiqNro, LiqExenConCodigo, LiqExenImp FROM liquidacion_exencion WHERE (CliCod = ? and EmpCod = ? and LiqExAnio = ?) AND (LegNumero = ?) AND (LiqExAplIIGG = ?) ORDER BY CliCod, EmpCod, LiqExAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017O3", "SELECT LiqNro, LiqExAplIIGG, LegNumero, LiqExAnio, EmpCod, CliCod, LiqExenConCodigo, LiqExenImp FROM liquidacion_exencion WHERE (CliCod = ? and EmpCod = ? and LiqExAnio = ?) AND (LegNumero = ?) AND (LiqExAplIIGG = ?) AND (LiqNro <= ?) ORDER BY CliCod, EmpCod, LiqExAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

