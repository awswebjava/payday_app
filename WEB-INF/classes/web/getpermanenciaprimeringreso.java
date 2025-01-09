package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpermanenciaprimeringreso extends GXProcedure
{
   public getpermanenciaprimeringreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpermanenciaprimeringreso.class ), "" );
   }

   public getpermanenciaprimeringreso( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 )
   {
      getpermanenciaprimeringreso.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 )
   {
      getpermanenciaprimeringreso.this.AV11CliCod = aP0;
      getpermanenciaprimeringreso.this.AV10EmpCod = aP1;
      getpermanenciaprimeringreso.this.AV9LegNumero = aP2;
      getpermanenciaprimeringreso.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02BQ2_A6LegNumero[0] ;
         A1EmpCod = P02BQ2_A1EmpCod[0] ;
         A3CliCod = P02BQ2_A3CliCod[0] ;
         A2253LegHisFecIng = P02BQ2_A2253LegHisFecIng[0] ;
         AV8LegHisFecIng = A2253LegHisFecIng ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getpermanenciaprimeringreso.this.AV8LegHisFecIng;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LegHisFecIng = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02BQ2_A6LegNumero = new int[1] ;
      P02BQ2_A1EmpCod = new short[1] ;
      P02BQ2_A3CliCod = new int[1] ;
      P02BQ2_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpermanenciaprimeringreso__default(),
         new Object[] {
             new Object[] {
            P02BQ2_A6LegNumero, P02BQ2_A1EmpCod, P02BQ2_A3CliCod, P02BQ2_A2253LegHisFecIng
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV8LegHisFecIng ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02BQ2_A6LegNumero ;
   private short[] P02BQ2_A1EmpCod ;
   private int[] P02BQ2_A3CliCod ;
   private java.util.Date[] P02BQ2_A2253LegHisFecIng ;
}

final  class getpermanenciaprimeringreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BQ2", "SELECT LegNumero, EmpCod, CliCod, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
      }
   }

}

