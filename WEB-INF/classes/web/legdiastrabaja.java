package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legdiastrabaja extends GXProcedure
{
   public legdiastrabaja( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legdiastrabaja.class ), "" );
   }

   public legdiastrabaja( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              boolean[] aP3 ,
                              boolean[] aP4 ,
                              boolean[] aP5 ,
                              boolean[] aP6 ,
                              boolean[] aP7 ,
                              boolean[] aP8 )
   {
      legdiastrabaja.this.aP9 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 ,
                        boolean[] aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 ,
                        boolean[] aP7 ,
                        boolean[] aP8 ,
                        boolean[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 ,
                             boolean[] aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 ,
                             boolean[] aP7 ,
                             boolean[] aP8 ,
                             boolean[] aP9 )
   {
      legdiastrabaja.this.AV10CliCod = aP0;
      legdiastrabaja.this.AV9EmpCod = aP1;
      legdiastrabaja.this.AV8LegNumero = aP2;
      legdiastrabaja.this.aP3 = aP3;
      legdiastrabaja.this.aP4 = aP4;
      legdiastrabaja.this.aP5 = aP5;
      legdiastrabaja.this.aP6 = aP6;
      legdiastrabaja.this.aP7 = aP7;
      legdiastrabaja.this.aP8 = aP8;
      legdiastrabaja.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01LB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01LB2_A6LegNumero[0] ;
         A1EmpCod = P01LB2_A1EmpCod[0] ;
         A3CliCod = P01LB2_A3CliCod[0] ;
         A1251LegTrabDo = P01LB2_A1251LegTrabDo[0] ;
         A1245LegTrabLun = P01LB2_A1245LegTrabLun[0] ;
         A1246LegTrabMar = P01LB2_A1246LegTrabMar[0] ;
         A1247LegTrabMie = P01LB2_A1247LegTrabMie[0] ;
         A1248LegTrabJue = P01LB2_A1248LegTrabJue[0] ;
         A1249LegTrabVie = P01LB2_A1249LegTrabVie[0] ;
         A1250LegTrabSa = P01LB2_A1250LegTrabSa[0] ;
         AV13LegTrabDo = A1251LegTrabDo ;
         AV19LegTrabLun = A1245LegTrabLun ;
         AV18LegTrabMar = A1246LegTrabMar ;
         AV14LegTrabMie = A1247LegTrabMie ;
         AV15LegTrabJue = A1248LegTrabJue ;
         AV17LegTrabVie = A1249LegTrabVie ;
         AV16LegTrabSa = A1250LegTrabSa ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = legdiastrabaja.this.AV13LegTrabDo;
      this.aP4[0] = legdiastrabaja.this.AV19LegTrabLun;
      this.aP5[0] = legdiastrabaja.this.AV18LegTrabMar;
      this.aP6[0] = legdiastrabaja.this.AV14LegTrabMie;
      this.aP7[0] = legdiastrabaja.this.AV15LegTrabJue;
      this.aP8[0] = legdiastrabaja.this.AV17LegTrabVie;
      this.aP9[0] = legdiastrabaja.this.AV16LegTrabSa;
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
      P01LB2_A6LegNumero = new int[1] ;
      P01LB2_A1EmpCod = new short[1] ;
      P01LB2_A3CliCod = new int[1] ;
      P01LB2_A1251LegTrabDo = new boolean[] {false} ;
      P01LB2_A1245LegTrabLun = new boolean[] {false} ;
      P01LB2_A1246LegTrabMar = new boolean[] {false} ;
      P01LB2_A1247LegTrabMie = new boolean[] {false} ;
      P01LB2_A1248LegTrabJue = new boolean[] {false} ;
      P01LB2_A1249LegTrabVie = new boolean[] {false} ;
      P01LB2_A1250LegTrabSa = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legdiastrabaja__default(),
         new Object[] {
             new Object[] {
            P01LB2_A6LegNumero, P01LB2_A1EmpCod, P01LB2_A3CliCod, P01LB2_A1251LegTrabDo, P01LB2_A1245LegTrabLun, P01LB2_A1246LegTrabMar, P01LB2_A1247LegTrabMie, P01LB2_A1248LegTrabJue, P01LB2_A1249LegTrabVie, P01LB2_A1250LegTrabSa
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV13LegTrabDo ;
   private boolean AV19LegTrabLun ;
   private boolean AV18LegTrabMar ;
   private boolean AV14LegTrabMie ;
   private boolean AV15LegTrabJue ;
   private boolean AV17LegTrabVie ;
   private boolean AV16LegTrabSa ;
   private boolean A1251LegTrabDo ;
   private boolean A1245LegTrabLun ;
   private boolean A1246LegTrabMar ;
   private boolean A1247LegTrabMie ;
   private boolean A1248LegTrabJue ;
   private boolean A1249LegTrabVie ;
   private boolean A1250LegTrabSa ;
   private boolean[] aP9 ;
   private boolean[] aP3 ;
   private boolean[] aP4 ;
   private boolean[] aP5 ;
   private boolean[] aP6 ;
   private boolean[] aP7 ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P01LB2_A6LegNumero ;
   private short[] P01LB2_A1EmpCod ;
   private int[] P01LB2_A3CliCod ;
   private boolean[] P01LB2_A1251LegTrabDo ;
   private boolean[] P01LB2_A1245LegTrabLun ;
   private boolean[] P01LB2_A1246LegTrabMar ;
   private boolean[] P01LB2_A1247LegTrabMie ;
   private boolean[] P01LB2_A1248LegTrabJue ;
   private boolean[] P01LB2_A1249LegTrabVie ;
   private boolean[] P01LB2_A1250LegTrabSa ;
}

final  class legdiastrabaja__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LB2", "SELECT LegNumero, EmpCod, CliCod, LegTrabDo, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
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

