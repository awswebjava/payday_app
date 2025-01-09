package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_liquidacion_exencion extends GXProcedure
{
   public new_liquidacion_exencion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_liquidacion_exencion.class ), "" );
   }

   public new_liquidacion_exencion( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              short aP2 ,
                              int aP3 ,
                              int aP4 ,
                              short aP5 ,
                              String aP6 ,
                              java.math.BigDecimal aP7 )
   {
      new_liquidacion_exencion.this.aP8 = new boolean[] {false};
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
                        java.math.BigDecimal aP7 ,
                        boolean[] aP8 )
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
                             java.math.BigDecimal aP7 ,
                             boolean[] aP8 )
   {
      new_liquidacion_exencion.this.AV13CliCod = aP0;
      new_liquidacion_exencion.this.AV12EmpCod = aP1;
      new_liquidacion_exencion.this.AV15LiqExAnio = aP2;
      new_liquidacion_exencion.this.AV11LiqNro = aP3;
      new_liquidacion_exencion.this.AV10LegNumero = aP4;
      new_liquidacion_exencion.this.AV9AplIIGG = aP5;
      new_liquidacion_exencion.this.AV14LiqExenConCodigo = aP6;
      new_liquidacion_exencion.this.AV8LiqExenImp = aP7;
      new_liquidacion_exencion.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "graba liquidacion exencion insert ", "")+GXutil.trim( GXutil.str( AV8LiqExenImp, 14, 2))) ;
      /*
         INSERT RECORD ON TABLE liquidacion_exencion

      */
      A3CliCod = AV13CliCod ;
      A1EmpCod = AV12EmpCod ;
      A1129LiqExAnio = AV15LiqExAnio ;
      A31LiqNro = AV11LiqNro ;
      A6LegNumero = AV10LegNumero ;
      A1128LiqExAplIIGG = AV9AplIIGG ;
      A1127LiqExenConCodigo = AV14LiqExenConCodigo ;
      A1126LiqExenImp = AV8LiqExenImp ;
      /* Using cursor P017N2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1129LiqExAnio), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), A1127LiqExenConCodigo, Short.valueOf(A1128LiqExAplIIGG), A1126LiqExenImp});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacion_exencion");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         AV16yaExiste = true ;
         /* Using cursor P017N3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1129LiqExAnio), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), A1127LiqExenConCodigo, Short.valueOf(A1128LiqExAplIIGG)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P017N3_A3CliCod[0] ;
            A1EmpCod = P017N3_A1EmpCod[0] ;
            A1129LiqExAnio = P017N3_A1129LiqExAnio[0] ;
            A31LiqNro = P017N3_A31LiqNro[0] ;
            A6LegNumero = P017N3_A6LegNumero[0] ;
            A1127LiqExenConCodigo = P017N3_A1127LiqExenConCodigo[0] ;
            A1128LiqExAplIIGG = P017N3_A1128LiqExAplIIGG[0] ;
            A1126LiqExenImp = P017N3_A1126LiqExenImp[0] ;
            A1126LiqExenImp = AV8LiqExenImp ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "ya existe graba ", "")+GXutil.trim( GXutil.str( AV8LiqExenImp, 14, 2))) ;
            /* Using cursor P017N4 */
            pr_default.execute(2, new Object[] {A1126LiqExenImp, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1129LiqExAnio), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), A1127LiqExenConCodigo, Short.valueOf(A1128LiqExAplIIGG)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacion_exencion");
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      if ( false )
      {
         GXv_boolean1[0] = false ;
         new web.pruebapostgres(remoteHandle, context).execute( GXv_boolean1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = new_liquidacion_exencion.this.AV16yaExiste;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Pgmname = "" ;
      A1127LiqExenConCodigo = "" ;
      A1126LiqExenImp = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P017N3_A3CliCod = new int[1] ;
      P017N3_A1EmpCod = new short[1] ;
      P017N3_A1129LiqExAnio = new short[1] ;
      P017N3_A31LiqNro = new int[1] ;
      P017N3_A6LegNumero = new int[1] ;
      P017N3_A1127LiqExenConCodigo = new String[] {""} ;
      P017N3_A1128LiqExAplIIGG = new short[1] ;
      P017N3_A1126LiqExenImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_liquidacion_exencion__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P017N3_A3CliCod, P017N3_A1EmpCod, P017N3_A1129LiqExAnio, P017N3_A31LiqNro, P017N3_A6LegNumero, P017N3_A1127LiqExenConCodigo, P017N3_A1128LiqExAplIIGG, P017N3_A1126LiqExenImp
            }
            , new Object[] {
            }
         }
      );
      AV19Pgmname = "new_liquidacion_exencion" ;
      /* GeneXus formulas. */
      AV19Pgmname = "new_liquidacion_exencion" ;
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV15LiqExAnio ;
   private short AV9AplIIGG ;
   private short A1EmpCod ;
   private short A1129LiqExAnio ;
   private short A1128LiqExAplIIGG ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int GX_INS127 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV8LiqExenImp ;
   private java.math.BigDecimal A1126LiqExenImp ;
   private String AV14LiqExenConCodigo ;
   private String AV19Pgmname ;
   private String A1127LiqExenConCodigo ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private boolean AV16yaExiste ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P017N3_A3CliCod ;
   private short[] P017N3_A1EmpCod ;
   private short[] P017N3_A1129LiqExAnio ;
   private int[] P017N3_A31LiqNro ;
   private int[] P017N3_A6LegNumero ;
   private String[] P017N3_A1127LiqExenConCodigo ;
   private short[] P017N3_A1128LiqExAplIIGG ;
   private java.math.BigDecimal[] P017N3_A1126LiqExenImp ;
}

final  class new_liquidacion_exencion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P017N2", "SAVEPOINT gxupdate;INSERT INTO liquidacion_exencion(CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG, LiqExenImp) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P017N3", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG, LiqExenImp FROM liquidacion_exencion WHERE CliCod = ? and EmpCod = ? and LiqExAnio = ? and LiqNro = ? and LegNumero = ? and LiqExenConCodigo = ( ?) and LiqExAplIIGG = ? ORDER BY CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG  FOR UPDATE OF liquidacion_exencion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P017N4", "SAVEPOINT gxupdate;UPDATE liquidacion_exencion SET LiqExenImp=?  WHERE CliCod = ? AND EmpCod = ? AND LiqExAnio = ? AND LiqNro = ? AND LegNumero = ? AND LiqExenConCodigo = ? AND LiqExAplIIGG = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
      }
   }

}

