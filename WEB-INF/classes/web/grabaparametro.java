package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaparametro extends GXProcedure
{
   public grabaparametro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaparametro.class ), "" );
   }

   public grabaparametro( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      grabaparametro.this.AV8CliCod = aP0;
      grabaparametro.this.AV9ParmCod = aP1;
      grabaparametro.this.AV10ParmValue = aP2;
      grabaparametro.this.AV13parmParmDescri = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+" - "+AV9ParmCod+" - "+AV10ParmValue) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&ParmDescri: ", "")+GXutil.trim( AV11ParmDescri)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&ConDescrip: ", "")+GXutil.trim( AV14ConDescrip)) ;
      AV18GXLvl6 = (byte)(0) ;
      /* Using cursor P00GK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ParmCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A61ParmCod = P00GK2_A61ParmCod[0] ;
         A3CliCod = P00GK2_A3CliCod[0] ;
         A316ParmValue = P00GK2_A316ParmValue[0] ;
         A315ParmDescri = P00GK2_A315ParmDescri[0] ;
         AV18GXLvl6 = (byte)(1) ;
         A316ParmValue = AV10ParmValue ;
         if ( ! (GXutil.strcmp("", AV13parmParmDescri)==0) )
         {
            A315ParmDescri = AV13parmParmDescri ;
         }
         /* Using cursor P00GK3 */
         pr_default.execute(1, new Object[] {A316ParmValue, A315ParmDescri, Integer.valueOf(A3CliCod), A61ParmCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Param");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV18GXLvl6 == 0 )
      {
         if ( (GXutil.strcmp("", AV13parmParmDescri)==0) )
         {
            GXv_char1[0] = AV14ConDescrip ;
            new web.conceptogetdescri(remoteHandle, context).execute( AV8CliCod, AV10ParmValue, GXv_char1) ;
            grabaparametro.this.AV14ConDescrip = GXv_char1[0] ;
            AV11ParmDescri = httpContext.getMessage( "Concepto \"", "") + GXutil.trim( AV14ConDescrip) + "\"" ;
         }
         else
         {
            AV11ParmDescri = GXutil.trim( AV13parmParmDescri) ;
         }
         /*
            INSERT RECORD ON TABLE Param

         */
         A3CliCod = AV8CliCod ;
         A61ParmCod = AV9ParmCod ;
         A316ParmValue = AV10ParmValue ;
         A315ParmDescri = AV11ParmDescri ;
         A887ParmTipo = "CONCEPTO" ;
         A1364ParmDatoTipo = "" ;
         A1996ParmRelSec = 0 ;
         A1997ParmRelSecCli = 0 ;
         A2019ParmRelRef = "" ;
         A2031ParmOld = "" ;
         /* Using cursor P00GK4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A61ParmCod, A316ParmValue, A315ParmDescri, A887ParmTipo, A1364ParmDatoTipo, Integer.valueOf(A1996ParmRelSec), Integer.valueOf(A1997ParmRelSecCli), A2019ParmRelRef, A2031ParmOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Param");
         if ( (pr_default.getStatus(2) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         new web.msgdebug(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "new", "")) ;
      }
      new web.removerdesesion(remoteHandle, context).execute( httpContext.getMessage( "getParametro_", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+"_"+GXutil.trim( AV9ParmCod)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaparametro");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Pgmname = "" ;
      AV11ParmDescri = "" ;
      AV14ConDescrip = "" ;
      scmdbuf = "" ;
      P00GK2_A61ParmCod = new String[] {""} ;
      P00GK2_A3CliCod = new int[1] ;
      P00GK2_A316ParmValue = new String[] {""} ;
      P00GK2_A315ParmDescri = new String[] {""} ;
      A61ParmCod = "" ;
      A316ParmValue = "" ;
      A315ParmDescri = "" ;
      GXv_char1 = new String[1] ;
      A887ParmTipo = "" ;
      A1364ParmDatoTipo = "" ;
      A2019ParmRelRef = "" ;
      A2031ParmOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaparametro__default(),
         new Object[] {
             new Object[] {
            P00GK2_A61ParmCod, P00GK2_A3CliCod, P00GK2_A316ParmValue, P00GK2_A315ParmDescri
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV17Pgmname = "GrabaParametro" ;
      /* GeneXus formulas. */
      AV17Pgmname = "GrabaParametro" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl6 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int GX_INS39 ;
   private int A1996ParmRelSec ;
   private int A1997ParmRelSecCli ;
   private String AV9ParmCod ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A61ParmCod ;
   private String GXv_char1[] ;
   private String A887ParmTipo ;
   private String A1364ParmDatoTipo ;
   private String Gx_emsg ;
   private String AV10ParmValue ;
   private String A316ParmValue ;
   private String A2031ParmOld ;
   private String AV13parmParmDescri ;
   private String AV11ParmDescri ;
   private String AV14ConDescrip ;
   private String A315ParmDescri ;
   private String A2019ParmRelRef ;
   private IDataStoreProvider pr_default ;
   private String[] P00GK2_A61ParmCod ;
   private int[] P00GK2_A3CliCod ;
   private String[] P00GK2_A316ParmValue ;
   private String[] P00GK2_A315ParmDescri ;
}

final  class grabaparametro__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GK2", "SELECT ParmCod, CliCod, ParmValue, ParmDescri FROM Param WHERE CliCod = ? and ParmCod = ( ?) ORDER BY CliCod, ParmCod  FOR UPDATE OF Param",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00GK3", "SAVEPOINT gxupdate;UPDATE Param SET ParmValue=?, ParmDescri=?  WHERE CliCod = ? AND ParmCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00GK4", "SAVEPOINT gxupdate;INSERT INTO Param(CliCod, ParmCod, ParmValue, ParmDescri, ParmTipo, ParmDatoTipo, ParmRelSec, ParmRelSecCli, ParmRelRef, ParmOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 30);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setString(2, (String)parms[1], 30);
               return;
            case 1 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 30);
               return;
            case 2 :
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

