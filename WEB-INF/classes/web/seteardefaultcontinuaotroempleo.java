package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class seteardefaultcontinuaotroempleo extends GXProcedure
{
   public seteardefaultcontinuaotroempleo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( seteardefaultcontinuaotroempleo.class ), "" );
   }

   public seteardefaultcontinuaotroempleo( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      seteardefaultcontinuaotroempleo.this.AV10CliCod = aP0;
      seteardefaultcontinuaotroempleo.this.AV9EmpCod = aP1;
      seteardefaultcontinuaotroempleo.this.AV8LegNumero = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00W72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00W72_A6LegNumero[0] ;
         A1EmpCod = P00W72_A1EmpCod[0] ;
         A3CliCod = P00W72_A3CliCod[0] ;
         A879LegContinua = P00W72_A879LegContinua[0] ;
         if ( GXutil.strcmp(A879LegContinua, "") == 0 )
         {
            AV11hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
            GXv_boolean1[0] = AV12otroEmpleoTiene ;
            new web.tieneotroempleosegunsiradig(remoteHandle, context).execute( AV10CliCod, AV9EmpCod, AV8LegNumero, AV11hoy, GXv_boolean1) ;
            seteardefaultcontinuaotroempleo.this.AV12otroEmpleoTiene = GXv_boolean1[0] ;
            if ( AV12otroEmpleoTiene )
            {
               A879LegContinua = "SI" ;
            }
            else
            {
               A879LegContinua = "NO" ;
            }
         }
         /* Using cursor P00W73 */
         pr_default.execute(1, new Object[] {A879LegContinua, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "seteardefaultcontinuaotroempleo");
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
      P00W72_A6LegNumero = new int[1] ;
      P00W72_A1EmpCod = new short[1] ;
      P00W72_A3CliCod = new int[1] ;
      P00W72_A879LegContinua = new String[] {""} ;
      A879LegContinua = "" ;
      AV11hoy = GXutil.nullDate() ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.seteardefaultcontinuaotroempleo__default(),
         new Object[] {
             new Object[] {
            P00W72_A6LegNumero, P00W72_A1EmpCod, P00W72_A3CliCod, P00W72_A879LegContinua
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A879LegContinua ;
   private java.util.Date AV11hoy ;
   private boolean AV12otroEmpleoTiene ;
   private boolean GXv_boolean1[] ;
   private IDataStoreProvider pr_default ;
   private int[] P00W72_A6LegNumero ;
   private short[] P00W72_A1EmpCod ;
   private int[] P00W72_A3CliCod ;
   private String[] P00W72_A879LegContinua ;
}

final  class seteardefaultcontinuaotroempleo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00W72", "SELECT LegNumero, EmpCod, CliCod, LegContinua FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero  FOR UPDATE OF Legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00W73", "SAVEPOINT gxupdate;UPDATE Legajo SET LegContinua=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 2);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

