package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importarparametros extends GXProcedure
{
   public importarparametros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarparametros.class ), "" );
   }

   public importarparametros( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int aP1 )
   {
      importarparametros.this.AV8Orig_CliCod = aP0;
      importarparametros.this.AV9CliCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00RH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8Orig_CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A887ParmTipo = P00RH2_A887ParmTipo[0] ;
         A315ParmDescri = P00RH2_A315ParmDescri[0] ;
         A316ParmValue = P00RH2_A316ParmValue[0] ;
         A61ParmCod = P00RH2_A61ParmCod[0] ;
         A3CliCod = P00RH2_A3CliCod[0] ;
         A2031ParmOld = P00RH2_A2031ParmOld[0] ;
         A2019ParmRelRef = P00RH2_A2019ParmRelRef[0] ;
         A1997ParmRelSecCli = P00RH2_A1997ParmRelSecCli[0] ;
         A1996ParmRelSec = P00RH2_A1996ParmRelSec[0] ;
         A1364ParmDatoTipo = P00RH2_A1364ParmDatoTipo[0] ;
         W3CliCod = A3CliCod ;
         AV10ParmCod = A61ParmCod ;
         AV11ParmValue = A316ParmValue ;
         AV12ParmDescri = A315ParmDescri ;
         /*
            INSERT RECORD ON TABLE Param

         */
         W3CliCod = A3CliCod ;
         W61ParmCod = A61ParmCod ;
         W316ParmValue = A316ParmValue ;
         W315ParmDescri = A315ParmDescri ;
         W887ParmTipo = A887ParmTipo ;
         A3CliCod = AV9CliCod ;
         A61ParmCod = AV10ParmCod ;
         A316ParmValue = GXutil.trim( AV11ParmValue) ;
         A315ParmDescri = GXutil.trim( AV12ParmDescri) ;
         A887ParmTipo = "" ;
         /* Using cursor P00RH3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod, A316ParmValue, A315ParmDescri, A887ParmTipo, A1364ParmDatoTipo, Integer.valueOf(A1996ParmRelSec), Integer.valueOf(A1997ParmRelSecCli), A2019ParmRelRef, A2031ParmOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Param");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         A3CliCod = W3CliCod ;
         A61ParmCod = W61ParmCod ;
         A316ParmValue = W316ParmValue ;
         A315ParmDescri = W315ParmDescri ;
         A887ParmTipo = W887ParmTipo ;
         /* End Insert */
         A3CliCod = W3CliCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "importarparametros");
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
      P00RH2_A887ParmTipo = new String[] {""} ;
      P00RH2_A315ParmDescri = new String[] {""} ;
      P00RH2_A316ParmValue = new String[] {""} ;
      P00RH2_A61ParmCod = new String[] {""} ;
      P00RH2_A3CliCod = new int[1] ;
      P00RH2_A2031ParmOld = new String[] {""} ;
      P00RH2_A2019ParmRelRef = new String[] {""} ;
      P00RH2_A1997ParmRelSecCli = new int[1] ;
      P00RH2_A1996ParmRelSec = new int[1] ;
      P00RH2_A1364ParmDatoTipo = new String[] {""} ;
      A887ParmTipo = "" ;
      A315ParmDescri = "" ;
      A316ParmValue = "" ;
      A61ParmCod = "" ;
      A2031ParmOld = "" ;
      A2019ParmRelRef = "" ;
      A1364ParmDatoTipo = "" ;
      AV10ParmCod = "" ;
      AV11ParmValue = "" ;
      AV12ParmDescri = "" ;
      W61ParmCod = "" ;
      W316ParmValue = "" ;
      W315ParmDescri = "" ;
      W887ParmTipo = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarparametros__default(),
         new Object[] {
             new Object[] {
            P00RH2_A887ParmTipo, P00RH2_A315ParmDescri, P00RH2_A316ParmValue, P00RH2_A61ParmCod, P00RH2_A3CliCod, P00RH2_A2031ParmOld, P00RH2_A2019ParmRelRef, P00RH2_A1997ParmRelSecCli, P00RH2_A1996ParmRelSec, P00RH2_A1364ParmDatoTipo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8Orig_CliCod ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int A1997ParmRelSecCli ;
   private int A1996ParmRelSec ;
   private int W3CliCod ;
   private int GX_INS39 ;
   private String scmdbuf ;
   private String A887ParmTipo ;
   private String A61ParmCod ;
   private String A1364ParmDatoTipo ;
   private String AV10ParmCod ;
   private String W61ParmCod ;
   private String W887ParmTipo ;
   private String Gx_emsg ;
   private String A316ParmValue ;
   private String A2031ParmOld ;
   private String AV11ParmValue ;
   private String W316ParmValue ;
   private String A315ParmDescri ;
   private String A2019ParmRelRef ;
   private String AV12ParmDescri ;
   private String W315ParmDescri ;
   private IDataStoreProvider pr_default ;
   private String[] P00RH2_A887ParmTipo ;
   private String[] P00RH2_A315ParmDescri ;
   private String[] P00RH2_A316ParmValue ;
   private String[] P00RH2_A61ParmCod ;
   private int[] P00RH2_A3CliCod ;
   private String[] P00RH2_A2031ParmOld ;
   private String[] P00RH2_A2019ParmRelRef ;
   private int[] P00RH2_A1997ParmRelSecCli ;
   private int[] P00RH2_A1996ParmRelSec ;
   private String[] P00RH2_A1364ParmDatoTipo ;
}

final  class importarparametros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RH2", "SELECT ParmTipo, ParmDescri, ParmValue, ParmCod, CliCod, ParmOld, ParmRelRef, ParmRelSecCli, ParmRelSec, ParmDatoTipo FROM Param WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00RH3", "SAVEPOINT gxupdate;INSERT INTO Param(CliCod, ParmCod, ParmValue, ParmDescri, ParmTipo, ParmDatoTipo, ParmRelSec, ParmRelSecCli, ParmRelRef, ParmOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 30);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 30);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               return;
      }
   }

}

