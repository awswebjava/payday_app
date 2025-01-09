package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarconvenioycatlegajo extends GXProcedure
{
   public actualizarconvenioycatlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarconvenioycatlegajo.class ), "" );
   }

   public actualizarconvenioycatlegajo( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      actualizarconvenioycatlegajo.this.AV11CliCod = aP0;
      actualizarconvenioycatlegajo.this.AV12EmpCod = aP1;
      actualizarconvenioycatlegajo.this.AV8LegNumero = aP2;
      actualizarconvenioycatlegajo.this.AV9LegPaiCod = aP3;
      actualizarconvenioycatlegajo.this.AV13LegConveCodigo = aP4;
      actualizarconvenioycatlegajo.this.AV10LegCatCodigo = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P018F2_A6LegNumero[0] ;
         A1EmpCod = P018F2_A1EmpCod[0] ;
         A3CliCod = P018F2_A3CliCod[0] ;
         A937LegConveCodigo = P018F2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P018F2_n937LegConveCodigo[0] ;
         A939LegCatCodigo = P018F2_A939LegCatCodigo[0] ;
         n939LegCatCodigo = P018F2_n939LegCatCodigo[0] ;
         if ( ! (GXutil.strcmp("", AV13LegConveCodigo)==0) )
         {
            A937LegConveCodigo = AV13LegConveCodigo ;
            n937LegConveCodigo = false ;
         }
         else
         {
            A937LegConveCodigo = "" ;
            n937LegConveCodigo = false ;
            n937LegConveCodigo = true ;
         }
         if ( ! (GXutil.strcmp("", AV10LegCatCodigo)==0) )
         {
            A939LegCatCodigo = AV10LegCatCodigo ;
            n939LegCatCodigo = false ;
         }
         else
         {
            A939LegCatCodigo = "" ;
            n939LegCatCodigo = false ;
            n939LegCatCodigo = true ;
         }
         /* Using cursor P018F3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizarconvenioycatlegajo");
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
      P018F2_A6LegNumero = new int[1] ;
      P018F2_A1EmpCod = new short[1] ;
      P018F2_A3CliCod = new int[1] ;
      P018F2_A937LegConveCodigo = new String[] {""} ;
      P018F2_n937LegConveCodigo = new boolean[] {false} ;
      P018F2_A939LegCatCodigo = new String[] {""} ;
      P018F2_n939LegCatCodigo = new boolean[] {false} ;
      A937LegConveCodigo = "" ;
      A939LegCatCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarconvenioycatlegajo__default(),
         new Object[] {
             new Object[] {
            P018F2_A6LegNumero, P018F2_A1EmpCod, P018F2_A3CliCod, P018F2_A937LegConveCodigo, P018F2_n937LegConveCodigo, P018F2_A939LegCatCodigo, P018F2_n939LegCatCodigo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV9LegPaiCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV13LegConveCodigo ;
   private String AV10LegCatCodigo ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private String A939LegCatCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean n939LegCatCodigo ;
   private IDataStoreProvider pr_default ;
   private int[] P018F2_A6LegNumero ;
   private short[] P018F2_A1EmpCod ;
   private int[] P018F2_A3CliCod ;
   private String[] P018F2_A937LegConveCodigo ;
   private boolean[] P018F2_n937LegConveCodigo ;
   private String[] P018F2_A939LegCatCodigo ;
   private boolean[] P018F2_n939LegCatCodigo ;
}

final  class actualizarconvenioycatlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018F2", "SELECT LegNumero, EmpCod, CliCod, LegConveCodigo, LegCatCodigo FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero  FOR UPDATE OF Legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P018F3", "SAVEPOINT gxupdate;UPDATE Legajo SET LegConveCodigo=?, LegCatCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 40);
               }
               stmt.setInt(3, ((Number) parms[4]).intValue());
               stmt.setShort(4, ((Number) parms[5]).shortValue());
               stmt.setInt(5, ((Number) parms[6]).intValue());
               return;
      }
   }

}

