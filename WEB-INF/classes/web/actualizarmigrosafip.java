package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarmigrosafip extends GXProcedure
{
   public actualizarmigrosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarmigrosafip.class ), "" );
   }

   public actualizarmigrosafip( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      actualizarmigrosafip.this.AV12CliCod = aP0;
      actualizarmigrosafip.this.AV8EmpCod = aP1;
      actualizarmigrosafip.this.AV10MigrLegNumero = aP2;
      actualizarmigrosafip.this.AV11OsoCod = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))+httpContext.getMessage( " &OsoCod ", "")+AV11OsoCod) ;
      /* Using cursor P00M32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), AV11OsoCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A5OsoCod = P00M32_A5OsoCod[0] ;
         A3CliCod = P00M32_A3CliCod[0] ;
         A306OsoC3992 = P00M32_A306OsoC3992[0] ;
         n306OsoC3992 = P00M32_n306OsoC3992[0] ;
         AV9MigrLegOSAfip = A306OsoC3992 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "encuentra ", "")+AV9MigrLegOSAfip) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&MigrLegNumero ", "")+GXutil.trim( GXutil.str( AV10MigrLegNumero, 8, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))) ;
      /* Using cursor P00M33 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10MigrLegNumero)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A87MigrLegNumero = P00M33_A87MigrLegNumero[0] ;
         A1EmpCod = P00M33_A1EmpCod[0] ;
         A3CliCod = P00M33_A3CliCod[0] ;
         A634MigrLegOSAfip = P00M33_A634MigrLegOSAfip[0] ;
         A634MigrLegOSAfip = AV9MigrLegOSAfip ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "actualiza con &MigrLegOSAfip ", "")+AV9MigrLegOSAfip) ;
         /* Using cursor P00M34 */
         pr_default.execute(2, new Object[] {A634MigrLegOSAfip, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      P00M32_A5OsoCod = new String[] {""} ;
      P00M32_A3CliCod = new int[1] ;
      P00M32_A306OsoC3992 = new String[] {""} ;
      P00M32_n306OsoC3992 = new boolean[] {false} ;
      A5OsoCod = "" ;
      A306OsoC3992 = "" ;
      AV9MigrLegOSAfip = "" ;
      P00M33_A87MigrLegNumero = new int[1] ;
      P00M33_A1EmpCod = new short[1] ;
      P00M33_A3CliCod = new int[1] ;
      P00M33_A634MigrLegOSAfip = new String[] {""} ;
      A634MigrLegOSAfip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarmigrosafip__default(),
         new Object[] {
             new Object[] {
            P00M32_A5OsoCod, P00M32_A3CliCod, P00M32_A306OsoC3992, P00M32_n306OsoC3992
            }
            , new Object[] {
            P00M33_A87MigrLegNumero, P00M33_A1EmpCod, P00M33_A3CliCod, P00M33_A634MigrLegOSAfip
            }
            , new Object[] {
            }
         }
      );
      AV15Pgmname = "ActualizarMigrOSAfip" ;
      /* GeneXus formulas. */
      AV15Pgmname = "ActualizarMigrOSAfip" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10MigrLegNumero ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private String AV11OsoCod ;
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String A5OsoCod ;
   private String A306OsoC3992 ;
   private String AV9MigrLegOSAfip ;
   private String A634MigrLegOSAfip ;
   private boolean n306OsoC3992 ;
   private IDataStoreProvider pr_default ;
   private String[] P00M32_A5OsoCod ;
   private int[] P00M32_A3CliCod ;
   private String[] P00M32_A306OsoC3992 ;
   private boolean[] P00M32_n306OsoC3992 ;
   private int[] P00M33_A87MigrLegNumero ;
   private short[] P00M33_A1EmpCod ;
   private int[] P00M33_A3CliCod ;
   private String[] P00M33_A634MigrLegOSAfip ;
}

final  class actualizarmigrosafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M32", "SELECT OsoCod, CliCod, OsoC3992 FROM ObraSocial WHERE CliCod = ? and OsoCod = ( ?) ORDER BY CliCod, OsoCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00M33", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegOSAfip FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero  FOR UPDATE OF importacion_legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00M34", "SAVEPOINT gxupdate;UPDATE importacion_legajo SET MigrLegOSAfip=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

