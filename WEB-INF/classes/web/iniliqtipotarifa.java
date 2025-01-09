package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class iniliqtipotarifa extends GXProcedure
{
   public iniliqtipotarifa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( iniliqtipotarifa.class ), "" );
   }

   public iniliqtipotarifa( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LP2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A235LegClase = P02LP2_A235LegClase[0] ;
         A2417LegTipoTarifa = P02LP2_A2417LegTipoTarifa[0] ;
         A3CliCod = P02LP2_A3CliCod[0] ;
         A1EmpCod = P02LP2_A1EmpCod[0] ;
         A6LegNumero = P02LP2_A6LegNumero[0] ;
         if ( A235LegClase == 1 )
         {
            A2417LegTipoTarifa = "P" ;
         }
         else
         {
            A2417LegTipoTarifa = "H" ;
         }
         /* Using cursor P02LP3 */
         pr_default.execute(1, new Object[] {A2417LegTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P02LP4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A268LiqClase = P02LP4_A268LiqClase[0] ;
         n268LiqClase = P02LP4_n268LiqClase[0] ;
         A2426LiqTipoTarifa = P02LP4_A2426LiqTipoTarifa[0] ;
         A3CliCod = P02LP4_A3CliCod[0] ;
         A1EmpCod = P02LP4_A1EmpCod[0] ;
         A31LiqNro = P02LP4_A31LiqNro[0] ;
         if ( A268LiqClase == 0 )
         {
            A2426LiqTipoTarifa = "P" ;
         }
         else
         {
            A2426LiqTipoTarifa = "H" ;
         }
         /* Using cursor P02LP5 */
         pr_default.execute(3, new Object[] {A2426LiqTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "iniliqtipotarifa");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02LP2_A235LegClase = new byte[1] ;
      P02LP2_A2417LegTipoTarifa = new String[] {""} ;
      P02LP2_A3CliCod = new int[1] ;
      P02LP2_A1EmpCod = new short[1] ;
      P02LP2_A6LegNumero = new int[1] ;
      A2417LegTipoTarifa = "" ;
      P02LP4_A268LiqClase = new byte[1] ;
      P02LP4_n268LiqClase = new boolean[] {false} ;
      P02LP4_A2426LiqTipoTarifa = new String[] {""} ;
      P02LP4_A3CliCod = new int[1] ;
      P02LP4_A1EmpCod = new short[1] ;
      P02LP4_A31LiqNro = new int[1] ;
      A2426LiqTipoTarifa = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.iniliqtipotarifa__default(),
         new Object[] {
             new Object[] {
            P02LP2_A235LegClase, P02LP2_A2417LegTipoTarifa, P02LP2_A3CliCod, P02LP2_A1EmpCod, P02LP2_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            P02LP4_A268LiqClase, P02LP4_n268LiqClase, P02LP4_A2426LiqTipoTarifa, P02LP4_A3CliCod, P02LP4_A1EmpCod, P02LP4_A31LiqNro
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private byte A268LiqClase ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private String A2417LegTipoTarifa ;
   private String A2426LiqTipoTarifa ;
   private boolean n268LiqClase ;
   private IDataStoreProvider pr_default ;
   private byte[] P02LP2_A235LegClase ;
   private String[] P02LP2_A2417LegTipoTarifa ;
   private int[] P02LP2_A3CliCod ;
   private short[] P02LP2_A1EmpCod ;
   private int[] P02LP2_A6LegNumero ;
   private byte[] P02LP4_A268LiqClase ;
   private boolean[] P02LP4_n268LiqClase ;
   private String[] P02LP4_A2426LiqTipoTarifa ;
   private int[] P02LP4_A3CliCod ;
   private short[] P02LP4_A1EmpCod ;
   private int[] P02LP4_A31LiqNro ;
}

final  class iniliqtipotarifa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LP2", "SELECT LegClase, LegTipoTarifa, CliCod, EmpCod, LegNumero FROM Legajo ORDER BY CliCod, EmpCod, LegNumero  FOR UPDATE OF Legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02LP3", "SAVEPOINT gxupdate;UPDATE Legajo SET LegTipoTarifa=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02LP4", "SELECT LiqClase, LiqTipoTarifa, CliCod, EmpCod, LiqNro FROM Liquidacion ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02LP5", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqTipoTarifa=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 1);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

