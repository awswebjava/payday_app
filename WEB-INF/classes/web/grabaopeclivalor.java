package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaopeclivalor extends GXProcedure
{
   public grabaopeclivalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaopeclivalor.class ), "" );
   }

   public grabaopeclivalor( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date aP3 ,
                        boolean aP4 ,
                        String aP5 ,
                        int aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date aP3 ,
                             boolean aP4 ,
                             String aP5 ,
                             int aP6 ,
                             int aP7 )
   {
      grabaopeclivalor.this.AV8CliCod = aP0;
      grabaopeclivalor.this.AV9OpeCliId = aP1;
      grabaopeclivalor.this.AV11OpeCliVig = aP2;
      grabaopeclivalor.this.AV13OpeCliVRetro = aP3;
      grabaopeclivalor.this.AV14actualizarRetroactiva = aP4;
      grabaopeclivalor.this.AV12OpeCliValor = aP5;
      grabaopeclivalor.this.AV15OpeCliRelSec = aP6;
      grabaopeclivalor.this.AV16OpeCliRelSecCli = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE variable_valores

      */
      A3CliCod = AV8CliCod ;
      A82OpeCliId = AV9OpeCliId ;
      A754OpeCliVig = AV11OpeCliVig ;
      A535OpeCliValor = AV12OpeCliValor ;
      if ( AV14actualizarRetroactiva )
      {
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13OpeCliVRetro)) )
         {
            A1146OpeCliVRetro = GXutil.nullDate() ;
            n1146OpeCliVRetro = false ;
            n1146OpeCliVRetro = true ;
         }
         else
         {
            A1146OpeCliVRetro = AV13OpeCliVRetro ;
            n1146OpeCliVRetro = false ;
         }
      }
      A1890OpeCliRelSec = AV15OpeCliRelSec ;
      A1904OpeCliRelSecCli = AV16OpeCliRelSecCli ;
      A2010OpeCliVRelRef = "" ;
      A2032OpeCliVOld = "" ;
      /* Using cursor P016L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig, A535OpeCliValor, Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A1890OpeCliRelSec), Integer.valueOf(A1904OpeCliRelSecCli), A2010OpeCliVRelRef, A2032OpeCliVOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         /* Using cursor P016L3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P016L3_A3CliCod[0] ;
            A82OpeCliId = P016L3_A82OpeCliId[0] ;
            A754OpeCliVig = P016L3_A754OpeCliVig[0] ;
            A535OpeCliValor = P016L3_A535OpeCliValor[0] ;
            A1890OpeCliRelSec = P016L3_A1890OpeCliRelSec[0] ;
            A1904OpeCliRelSecCli = P016L3_A1904OpeCliRelSecCli[0] ;
            A1146OpeCliVRetro = P016L3_A1146OpeCliVRetro[0] ;
            n1146OpeCliVRetro = P016L3_n1146OpeCliVRetro[0] ;
            A535OpeCliValor = AV12OpeCliValor ;
            A1890OpeCliRelSec = AV15OpeCliRelSec ;
            A1904OpeCliRelSecCli = AV16OpeCliRelSecCli ;
            if ( AV14actualizarRetroactiva )
            {
               if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13OpeCliVRetro)) )
               {
                  A1146OpeCliVRetro = GXutil.nullDate() ;
                  n1146OpeCliVRetro = false ;
                  n1146OpeCliVRetro = true ;
               }
               else
               {
                  A1146OpeCliVRetro = AV13OpeCliVRetro ;
                  n1146OpeCliVRetro = false ;
               }
            }
            /* Using cursor P016L4 */
            pr_default.execute(2, new Object[] {A535OpeCliValor, Integer.valueOf(A1890OpeCliRelSec), Integer.valueOf(A1904OpeCliRelSecCli), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaopeclivalor");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A82OpeCliId = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A535OpeCliValor = "" ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      A2010OpeCliVRelRef = "" ;
      A2032OpeCliVOld = "" ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P016L3_A3CliCod = new int[1] ;
      P016L3_A82OpeCliId = new String[] {""} ;
      P016L3_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P016L3_A535OpeCliValor = new String[] {""} ;
      P016L3_A1890OpeCliRelSec = new int[1] ;
      P016L3_A1904OpeCliRelSecCli = new int[1] ;
      P016L3_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P016L3_n1146OpeCliVRetro = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaopeclivalor__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P016L3_A3CliCod, P016L3_A82OpeCliId, P016L3_A754OpeCliVig, P016L3_A535OpeCliValor, P016L3_A1890OpeCliRelSec, P016L3_A1904OpeCliRelSecCli, P016L3_A1146OpeCliVRetro, P016L3_n1146OpeCliVRetro
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15OpeCliRelSec ;
   private int AV16OpeCliRelSecCli ;
   private int GX_INS81 ;
   private int A3CliCod ;
   private int A1890OpeCliRelSec ;
   private int A1904OpeCliRelSecCli ;
   private String AV9OpeCliId ;
   private String A82OpeCliId ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date AV13OpeCliVRetro ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private boolean AV14actualizarRetroactiva ;
   private boolean n1146OpeCliVRetro ;
   private String AV12OpeCliValor ;
   private String A535OpeCliValor ;
   private String A2032OpeCliVOld ;
   private String A2010OpeCliVRelRef ;
   private IDataStoreProvider pr_default ;
   private int[] P016L3_A3CliCod ;
   private String[] P016L3_A82OpeCliId ;
   private java.util.Date[] P016L3_A754OpeCliVig ;
   private String[] P016L3_A535OpeCliValor ;
   private int[] P016L3_A1890OpeCliRelSec ;
   private int[] P016L3_A1904OpeCliRelSecCli ;
   private java.util.Date[] P016L3_A1146OpeCliVRetro ;
   private boolean[] P016L3_n1146OpeCliVRetro ;
}

final  class grabaopeclivalor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P016L2", "SAVEPOINT gxupdate;INSERT INTO variable_valores(CliCod, OpeCliId, OpeCliVig, OpeCliValor, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld, OpeCliVPropagar) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P016L3", "SELECT CliCod, OpeCliId, OpeCliVig, OpeCliValor, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRetro FROM variable_valores WHERE CliCod = ? and OpeCliId = ( ?) and OpeCliVig = ? ORDER BY CliCod, OpeCliId, OpeCliVig  FOR UPDATE OF variable_valores",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P016L4", "SAVEPOINT gxupdate;UPDATE variable_valores SET OpeCliValor=?, OpeCliRelSec=?, OpeCliRelSecCli=?, OpeCliVRetro=?  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[5]);
               }
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 2 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[4]);
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setString(6, (String)parms[6], 40);
               stmt.setDate(7, (java.util.Date)parms[7]);
               return;
      }
   }

}

