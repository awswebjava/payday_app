package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegtipotarifa extends GXProcedure
{
   public getlegtipotarifa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegtipotarifa.class ), "" );
   }

   public getlegtipotarifa( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegtipotarifa.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getlegtipotarifa.this.AV8CliCod = aP0;
      getlegtipotarifa.this.AV9EmpCod = aP1;
      getlegtipotarifa.this.AV10LegNumero = aP2;
      getlegtipotarifa.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02LO2_A6LegNumero[0] ;
         A1EmpCod = P02LO2_A1EmpCod[0] ;
         A3CliCod = P02LO2_A3CliCod[0] ;
         A2417LegTipoTarifa = P02LO2_A2417LegTipoTarifa[0] ;
         AV12LegTipoTarifa = A2417LegTipoTarifa ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegtipotarifa.this.AV12LegTipoTarifa;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegTipoTarifa = "" ;
      scmdbuf = "" ;
      P02LO2_A6LegNumero = new int[1] ;
      P02LO2_A1EmpCod = new short[1] ;
      P02LO2_A3CliCod = new int[1] ;
      P02LO2_A2417LegTipoTarifa = new String[] {""} ;
      A2417LegTipoTarifa = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegtipotarifa__default(),
         new Object[] {
             new Object[] {
            P02LO2_A6LegNumero, P02LO2_A1EmpCod, P02LO2_A3CliCod, P02LO2_A2417LegTipoTarifa
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
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV12LegTipoTarifa ;
   private String scmdbuf ;
   private String A2417LegTipoTarifa ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02LO2_A6LegNumero ;
   private short[] P02LO2_A1EmpCod ;
   private int[] P02LO2_A3CliCod ;
   private String[] P02LO2_A2417LegTipoTarifa ;
}

final  class getlegtipotarifa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LO2", "SELECT LegNumero, EmpCod, CliCod, LegTipoTarifa FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
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

