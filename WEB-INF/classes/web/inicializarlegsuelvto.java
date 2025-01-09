package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarlegsuelvto extends GXProcedure
{
   public inicializarlegsuelvto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarlegsuelvto.class ), "" );
   }

   public inicializarlegsuelvto( int remoteHandle ,
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
      /* Using cursor P02J52 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02J52_A3CliCod[0] ;
         A1136LegSuelFecha = P02J52_A1136LegSuelFecha[0] ;
         A2379LegSuelVto = P02J52_A2379LegSuelVto[0] ;
         A1EmpCod = P02J52_A1EmpCod[0] ;
         A6LegNumero = P02J52_A6LegNumero[0] ;
         A1135LegSuelSec = P02J52_A1135LegSuelSec[0] ;
         GXv_date1[0] = AV8LegSuelVto ;
         new web.calculafechavtosuelprecalc(remoteHandle, context).execute( A3CliCod, A1136LegSuelFecha, GXv_date1) ;
         inicializarlegsuelvto.this.AV8LegSuelVto = GXv_date1[0] ;
         A2379LegSuelVto = AV8LegSuelVto ;
         /* Using cursor P02J53 */
         pr_default.execute(1, new Object[] {A2379LegSuelVto, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarlegsuelvto");
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
      P02J52_A3CliCod = new int[1] ;
      P02J52_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P02J52_A2379LegSuelVto = new java.util.Date[] {GXutil.nullDate()} ;
      P02J52_A1EmpCod = new short[1] ;
      P02J52_A6LegNumero = new int[1] ;
      P02J52_A1135LegSuelSec = new short[1] ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      A2379LegSuelVto = GXutil.nullDate() ;
      AV8LegSuelVto = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarlegsuelvto__default(),
         new Object[] {
             new Object[] {
            P02J52_A3CliCod, P02J52_A1136LegSuelFecha, P02J52_A2379LegSuelVto, P02J52_A1EmpCod, P02J52_A6LegNumero, P02J52_A1135LegSuelSec
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short Gx_err ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private java.util.Date A1136LegSuelFecha ;
   private java.util.Date A2379LegSuelVto ;
   private java.util.Date AV8LegSuelVto ;
   private java.util.Date GXv_date1[] ;
   private IDataStoreProvider pr_default ;
   private int[] P02J52_A3CliCod ;
   private java.util.Date[] P02J52_A1136LegSuelFecha ;
   private java.util.Date[] P02J52_A2379LegSuelVto ;
   private short[] P02J52_A1EmpCod ;
   private int[] P02J52_A6LegNumero ;
   private short[] P02J52_A1135LegSuelSec ;
}

final  class inicializarlegsuelvto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02J52", "SELECT CliCod, LegSuelFecha, LegSuelVto, EmpCod, LegNumero, LegSuelSec FROM legajo_sueldos ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec  FOR UPDATE OF legajo_sueldos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02J53", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelVto=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

