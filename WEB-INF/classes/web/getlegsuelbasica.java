package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegsuelbasica extends GXProcedure
{
   public getlegsuelbasica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegsuelbasica.class ), "" );
   }

   public getlegsuelbasica( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short aP3 ,
                              java.util.Date aP4 )
   {
      getlegsuelbasica.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        java.util.Date aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             java.util.Date aP4 ,
                             boolean[] aP5 )
   {
      getlegsuelbasica.this.AV12CliCod = aP0;
      getlegsuelbasica.this.AV11EmpCod = aP1;
      getlegsuelbasica.this.AV10LegNumero = aP2;
      getlegsuelbasica.this.AV9LegSuelSec = aP3;
      getlegsuelbasica.this.AV13Fecha = aP4;
      getlegsuelbasica.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02DB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV9LegSuelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1135LegSuelSec = P02DB2_A1135LegSuelSec[0] ;
         A6LegNumero = P02DB2_A6LegNumero[0] ;
         A1EmpCod = P02DB2_A1EmpCod[0] ;
         A3CliCod = P02DB2_A3CliCod[0] ;
         A2379LegSuelVto = P02DB2_A2379LegSuelVto[0] ;
         A2359LegSuelCalCom = P02DB2_A2359LegSuelCalCom[0] ;
         A2357LegSuelBasica = P02DB2_A2357LegSuelBasica[0] ;
         if ( ( A2359LegSuelCalCom ) && GXutil.resetTime(AV13Fecha).before( GXutil.resetTime( A2379LegSuelVto )) )
         {
            AV8LegSuelBasica = A2357LegSuelBasica ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlegsuelbasica.this.AV8LegSuelBasica;
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
      P02DB2_A1135LegSuelSec = new short[1] ;
      P02DB2_A6LegNumero = new int[1] ;
      P02DB2_A1EmpCod = new short[1] ;
      P02DB2_A3CliCod = new int[1] ;
      P02DB2_A2379LegSuelVto = new java.util.Date[] {GXutil.nullDate()} ;
      P02DB2_A2359LegSuelCalCom = new boolean[] {false} ;
      P02DB2_A2357LegSuelBasica = new boolean[] {false} ;
      A2379LegSuelVto = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegsuelbasica__default(),
         new Object[] {
             new Object[] {
            P02DB2_A1135LegSuelSec, P02DB2_A6LegNumero, P02DB2_A1EmpCod, P02DB2_A3CliCod, P02DB2_A2379LegSuelVto, P02DB2_A2359LegSuelCalCom, P02DB2_A2357LegSuelBasica
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV9LegSuelSec ;
   private short A1135LegSuelSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV13Fecha ;
   private java.util.Date A2379LegSuelVto ;
   private boolean AV8LegSuelBasica ;
   private boolean A2359LegSuelCalCom ;
   private boolean A2357LegSuelBasica ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02DB2_A1135LegSuelSec ;
   private int[] P02DB2_A6LegNumero ;
   private short[] P02DB2_A1EmpCod ;
   private int[] P02DB2_A3CliCod ;
   private java.util.Date[] P02DB2_A2379LegSuelVto ;
   private boolean[] P02DB2_A2359LegSuelCalCom ;
   private boolean[] P02DB2_A2357LegSuelBasica ;
}

final  class getlegsuelbasica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DB2", "SELECT LegSuelSec, LegNumero, EmpCod, CliCod, LegSuelVto, LegSuelCalCom, LegSuelBasica FROM legajo_sueldos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ? ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
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
      }
   }

}

