package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setlegsuelbasica extends GXProcedure
{
   public setlegsuelbasica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setlegsuelbasica.class ), "" );
   }

   public setlegsuelbasica( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        boolean aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             boolean aP4 )
   {
      setlegsuelbasica.this.AV12CliCod = aP0;
      setlegsuelbasica.this.AV11EmpCod = aP1;
      setlegsuelbasica.this.AV10LegNumero = aP2;
      setlegsuelbasica.this.AV9LegSuelSec = aP3;
      setlegsuelbasica.this.AV8LegSuelBasica = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV16Pgmname, httpContext.getMessage( "&LegNumero", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &&LegSuelSec ", "")+GXutil.trim( GXutil.str( AV9LegSuelSec, 4, 0))+httpContext.getMessage( " &LegSuelBasica ", "")+GXutil.trim( GXutil.booltostr( AV8LegSuelBasica))) ;
      AV17GXLvl3 = (byte)(0) ;
      /* Using cursor P02DF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV9LegSuelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1135LegSuelSec = P02DF2_A1135LegSuelSec[0] ;
         A6LegNumero = P02DF2_A6LegNumero[0] ;
         A1EmpCod = P02DF2_A1EmpCod[0] ;
         A3CliCod = P02DF2_A3CliCod[0] ;
         A2357LegSuelBasica = P02DF2_A2357LegSuelBasica[0] ;
         A2344LegSuelTipo = P02DF2_A2344LegSuelTipo[0] ;
         n2344LegSuelTipo = P02DF2_n2344LegSuelTipo[0] ;
         A1136LegSuelFecha = P02DF2_A1136LegSuelFecha[0] ;
         A2379LegSuelVto = P02DF2_A2379LegSuelVto[0] ;
         AV17GXLvl3 = (byte)(1) ;
         A2357LegSuelBasica = AV8LegSuelBasica ;
         if ( P02DF2_n2344LegSuelTipo[0] || (GXutil.strcmp("", A2344LegSuelTipo)==0) )
         {
            A2344LegSuelTipo = "Bruto" ;
            n2344LegSuelTipo = false ;
         }
         if ( AV8LegSuelBasica )
         {
            GXv_date1[0] = AV13LegSuelVto ;
            new web.calculafechavtosuelprecalc(remoteHandle, context).execute( A3CliCod, A1136LegSuelFecha, GXv_date1) ;
            setlegsuelbasica.this.AV13LegSuelVto = GXv_date1[0] ;
            A2379LegSuelVto = AV13LegSuelVto ;
         }
         /* Using cursor P02DF3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A2357LegSuelBasica), Boolean.valueOf(n2344LegSuelTipo), A2344LegSuelTipo, A2379LegSuelVto, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV17GXLvl3 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV16Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setlegsuelbasica");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      P02DF2_A1135LegSuelSec = new short[1] ;
      P02DF2_A6LegNumero = new int[1] ;
      P02DF2_A1EmpCod = new short[1] ;
      P02DF2_A3CliCod = new int[1] ;
      P02DF2_A2357LegSuelBasica = new boolean[] {false} ;
      P02DF2_A2344LegSuelTipo = new String[] {""} ;
      P02DF2_n2344LegSuelTipo = new boolean[] {false} ;
      P02DF2_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P02DF2_A2379LegSuelVto = new java.util.Date[] {GXutil.nullDate()} ;
      A2344LegSuelTipo = "" ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      A2379LegSuelVto = GXutil.nullDate() ;
      AV13LegSuelVto = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setlegsuelbasica__default(),
         new Object[] {
             new Object[] {
            P02DF2_A1135LegSuelSec, P02DF2_A6LegNumero, P02DF2_A1EmpCod, P02DF2_A3CliCod, P02DF2_A2357LegSuelBasica, P02DF2_A2344LegSuelTipo, P02DF2_n2344LegSuelTipo, P02DF2_A1136LegSuelFecha, P02DF2_A2379LegSuelVto
            }
            , new Object[] {
            }
         }
      );
      AV16Pgmname = "setLegsuelBasica" ;
      /* GeneXus formulas. */
      AV16Pgmname = "setLegsuelBasica" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl3 ;
   private short AV11EmpCod ;
   private short AV9LegSuelSec ;
   private short A1135LegSuelSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A2344LegSuelTipo ;
   private java.util.Date A1136LegSuelFecha ;
   private java.util.Date A2379LegSuelVto ;
   private java.util.Date AV13LegSuelVto ;
   private java.util.Date GXv_date1[] ;
   private boolean AV8LegSuelBasica ;
   private boolean A2357LegSuelBasica ;
   private boolean n2344LegSuelTipo ;
   private IDataStoreProvider pr_default ;
   private short[] P02DF2_A1135LegSuelSec ;
   private int[] P02DF2_A6LegNumero ;
   private short[] P02DF2_A1EmpCod ;
   private int[] P02DF2_A3CliCod ;
   private boolean[] P02DF2_A2357LegSuelBasica ;
   private String[] P02DF2_A2344LegSuelTipo ;
   private boolean[] P02DF2_n2344LegSuelTipo ;
   private java.util.Date[] P02DF2_A1136LegSuelFecha ;
   private java.util.Date[] P02DF2_A2379LegSuelVto ;
}

final  class setlegsuelbasica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DF2", "SELECT LegSuelSec, LegNumero, EmpCod, CliCod, LegSuelBasica, LegSuelTipo, LegSuelFecha, LegSuelVto FROM legajo_sueldos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ? ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec  FOR UPDATE OF legajo_sueldos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02DF3", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelBasica=?, LegSuelTipo=?, LegSuelVto=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setDate(3, (java.util.Date)parms[3]);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               return;
      }
   }

}

