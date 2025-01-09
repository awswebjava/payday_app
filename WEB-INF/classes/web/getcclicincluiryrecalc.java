package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcclicincluiryrecalc extends GXProcedure
{
   public getcclicincluiryrecalc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcclicincluiryrecalc.class ), "" );
   }

   public getcclicincluiryrecalc( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              int aP3 ,
                              short aP4 ,
                              boolean[] aP5 ,
                              boolean[] aP6 )
   {
      getcclicincluiryrecalc.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        int aP3 ,
                        short aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             int aP3 ,
                             short aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 ,
                             boolean[] aP7 )
   {
      getcclicincluiryrecalc.this.AV14CliCod = aP0;
      getcclicincluiryrecalc.this.AV13EmpCod = aP1;
      getcclicincluiryrecalc.this.AV8LegCuenLicTpo = aP2;
      getcclicincluiryrecalc.this.AV12LegNumero = aP3;
      getcclicincluiryrecalc.this.AV9LegCuenAnio = aP4;
      getcclicincluiryrecalc.this.aP5 = aP5;
      getcclicincluiryrecalc.this.aP6 = aP6;
      getcclicincluiryrecalc.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV12LegNumero), AV8LegCuenLicTpo, Short.valueOf(AV9LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02BR2_A2266LegCuenAnio[0] ;
         A6LegNumero = P02BR2_A6LegNumero[0] ;
         A2243LegCuenLicTpo = P02BR2_A2243LegCuenLicTpo[0] ;
         A1EmpCod = P02BR2_A1EmpCod[0] ;
         A3CliCod = P02BR2_A3CliCod[0] ;
         A2321LegCuLIncluir = P02BR2_A2321LegCuLIncluir[0] ;
         A2322LegCuLRecalc = P02BR2_A2322LegCuLRecalc[0] ;
         AV11LegCuLIncluir = A2321LegCuLIncluir ;
         AV10LegCuLRecalc = A2322LegCuLRecalc ;
         AV15existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getcclicincluiryrecalc.this.AV11LegCuLIncluir;
      this.aP6[0] = getcclicincluiryrecalc.this.AV10LegCuLRecalc;
      this.aP7[0] = getcclicincluiryrecalc.this.AV15existe;
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
      P02BR2_A2266LegCuenAnio = new short[1] ;
      P02BR2_A6LegNumero = new int[1] ;
      P02BR2_A2243LegCuenLicTpo = new String[] {""} ;
      P02BR2_A1EmpCod = new short[1] ;
      P02BR2_A3CliCod = new int[1] ;
      P02BR2_A2321LegCuLIncluir = new boolean[] {false} ;
      P02BR2_A2322LegCuLRecalc = new boolean[] {false} ;
      A2243LegCuenLicTpo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcclicincluiryrecalc__default(),
         new Object[] {
             new Object[] {
            P02BR2_A2266LegCuenAnio, P02BR2_A6LegNumero, P02BR2_A2243LegCuenLicTpo, P02BR2_A1EmpCod, P02BR2_A3CliCod, P02BR2_A2321LegCuLIncluir, P02BR2_A2322LegCuLRecalc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV9LegCuenAnio ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV8LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private boolean AV11LegCuLIncluir ;
   private boolean AV10LegCuLRecalc ;
   private boolean AV15existe ;
   private boolean A2321LegCuLIncluir ;
   private boolean A2322LegCuLRecalc ;
   private boolean[] aP7 ;
   private boolean[] aP5 ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P02BR2_A2266LegCuenAnio ;
   private int[] P02BR2_A6LegNumero ;
   private String[] P02BR2_A2243LegCuenLicTpo ;
   private short[] P02BR2_A1EmpCod ;
   private int[] P02BR2_A3CliCod ;
   private boolean[] P02BR2_A2321LegCuLIncluir ;
   private boolean[] P02BR2_A2322LegCuLRecalc ;
}

final  class getcclicincluiryrecalc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BR2", "SELECT LegCuenAnio, LegNumero, LegCuenLicTpo, EmpCod, CliCod, LegCuLIncluir, LegCuLRecalc FROM legajo_cuenta_licencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

