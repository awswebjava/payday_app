package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegidnomape extends GXProcedure
{
   public getlegidnomape( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegidnomape.class ), "" );
   }

   public getlegidnomape( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegidnomape.this.aP3 = new String[] {""};
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
      getlegidnomape.this.AV11CliCod = aP0;
      getlegidnomape.this.AV8EmpCod = aP1;
      getlegidnomape.this.AV9LegNumero = aP2;
      getlegidnomape.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14GXLvl5 = (byte)(0) ;
      /* Using cursor P00AO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00AO2_A6LegNumero[0] ;
         A1EmpCod = P00AO2_A1EmpCod[0] ;
         A3CliCod = P00AO2_A3CliCod[0] ;
         A250LegIdNomApe = P00AO2_A250LegIdNomApe[0] ;
         AV14GXLvl5 = (byte)(1) ;
         AV10LegIdNomApe = GXutil.trim( A250LegIdNomApe) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV14GXLvl5 == 0 )
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegidnomape.this.AV10LegIdNomApe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LegIdNomApe = "" ;
      scmdbuf = "" ;
      P00AO2_A6LegNumero = new int[1] ;
      P00AO2_A1EmpCod = new short[1] ;
      P00AO2_A3CliCod = new int[1] ;
      P00AO2_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegidnomape__default(),
         new Object[] {
             new Object[] {
            P00AO2_A6LegNumero, P00AO2_A1EmpCod, P00AO2_A3CliCod, P00AO2_A250LegIdNomApe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14GXLvl5 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV10LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00AO2_A6LegNumero ;
   private short[] P00AO2_A1EmpCod ;
   private int[] P00AO2_A3CliCod ;
   private String[] P00AO2_A250LegIdNomApe ;
}

final  class getlegidnomape__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AO2", "SELECT LegNumero, EmpCod, CliCod, LegIdNomApe FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

