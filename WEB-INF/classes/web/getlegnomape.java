package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegnomape extends GXProcedure
{
   public getlegnomape( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegnomape.class ), "" );
   }

   public getlegnomape( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegnomape.this.aP3 = new String[] {""};
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
      getlegnomape.this.AV11CliCod = aP0;
      getlegnomape.this.AV8EmpCod = aP1;
      getlegnomape.this.AV9LegNumero = aP2;
      getlegnomape.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P00VZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00VZ2_A6LegNumero[0] ;
         A1EmpCod = P00VZ2_A1EmpCod[0] ;
         A3CliCod = P00VZ2_A3CliCod[0] ;
         A591LegNomApe = P00VZ2_A591LegNomApe[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV12LegNomApe = GXutil.trim( A591LegNomApe) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegnomape.this.AV12LegNomApe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegNomApe = "" ;
      scmdbuf = "" ;
      P00VZ2_A6LegNumero = new int[1] ;
      P00VZ2_A1EmpCod = new short[1] ;
      P00VZ2_A3CliCod = new int[1] ;
      P00VZ2_A591LegNomApe = new String[] {""} ;
      A591LegNomApe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegnomape__default(),
         new Object[] {
             new Object[] {
            P00VZ2_A6LegNumero, P00VZ2_A1EmpCod, P00VZ2_A3CliCod, P00VZ2_A591LegNomApe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl2 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV12LegNomApe ;
   private String A591LegNomApe ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00VZ2_A6LegNumero ;
   private short[] P00VZ2_A1EmpCod ;
   private int[] P00VZ2_A3CliCod ;
   private String[] P00VZ2_A591LegNomApe ;
}

final  class getlegnomape__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VZ2", "SELECT LegNumero, EmpCod, CliCod, LegNomApe FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

