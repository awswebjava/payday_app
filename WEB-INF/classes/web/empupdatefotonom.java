package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empupdatefotonom extends GXProcedure
{
   public empupdatefotonom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empupdatefotonom.class ), "" );
   }

   public empupdatefotonom( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      empupdatefotonom.this.AV8CliCod = aP0;
      empupdatefotonom.this.AV9EmpCod = aP1;
      empupdatefotonom.this.AV11que = aP2;
      empupdatefotonom.this.AV10EmpLogoNom = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02DZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02DZ2_A1EmpCod[0] ;
         A3CliCod = P02DZ2_A3CliCod[0] ;
         A956EmpLogoNom = P02DZ2_A956EmpLogoNom[0] ;
         n956EmpLogoNom = P02DZ2_n956EmpLogoNom[0] ;
         A959EmpFirmaNom = P02DZ2_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = P02DZ2_n959EmpFirmaNom[0] ;
         if ( GXutil.strcmp(AV11que, httpContext.getMessage( "logo", "")) == 0 )
         {
            A956EmpLogoNom = AV10EmpLogoNom ;
            n956EmpLogoNom = false ;
         }
         else
         {
            A959EmpFirmaNom = AV10EmpLogoNom ;
            n959EmpFirmaNom = false ;
         }
         /* Using cursor P02DZ3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n956EmpLogoNom), A956EmpLogoNom, Boolean.valueOf(n959EmpFirmaNom), A959EmpFirmaNom, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "empupdatefotonom");
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
      P02DZ2_A1EmpCod = new short[1] ;
      P02DZ2_A3CliCod = new int[1] ;
      P02DZ2_A956EmpLogoNom = new String[] {""} ;
      P02DZ2_n956EmpLogoNom = new boolean[] {false} ;
      P02DZ2_A959EmpFirmaNom = new String[] {""} ;
      P02DZ2_n959EmpFirmaNom = new boolean[] {false} ;
      A956EmpLogoNom = "" ;
      A959EmpFirmaNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empupdatefotonom__default(),
         new Object[] {
             new Object[] {
            P02DZ2_A1EmpCod, P02DZ2_A3CliCod, P02DZ2_A956EmpLogoNom, P02DZ2_n956EmpLogoNom, P02DZ2_A959EmpFirmaNom, P02DZ2_n959EmpFirmaNom
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
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV11que ;
   private String scmdbuf ;
   private boolean n956EmpLogoNom ;
   private boolean n959EmpFirmaNom ;
   private String AV10EmpLogoNom ;
   private String A956EmpLogoNom ;
   private String A959EmpFirmaNom ;
   private IDataStoreProvider pr_default ;
   private short[] P02DZ2_A1EmpCod ;
   private int[] P02DZ2_A3CliCod ;
   private String[] P02DZ2_A956EmpLogoNom ;
   private boolean[] P02DZ2_n956EmpLogoNom ;
   private String[] P02DZ2_A959EmpFirmaNom ;
   private boolean[] P02DZ2_n959EmpFirmaNom ;
}

final  class empupdatefotonom__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DZ2", "SELECT EmpCod, CliCod, EmpLogoNom, EmpFirmaNom FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod  FOR UPDATE OF Empresa",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02DZ3", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpLogoNom=?, EmpFirmaNom=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 400);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 400);
               }
               stmt.setInt(3, ((Number) parms[4]).intValue());
               stmt.setShort(4, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

