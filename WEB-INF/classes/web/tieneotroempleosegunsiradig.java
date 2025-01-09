package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tieneotroempleosegunsiradig extends GXProcedure
{
   public tieneotroempleosegunsiradig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tieneotroempleosegunsiradig.class ), "" );
   }

   public tieneotroempleosegunsiradig( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 )
   {
      tieneotroempleosegunsiradig.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean[] aP4 )
   {
      tieneotroempleosegunsiradig.this.AV8CliCod = aP0;
      tieneotroempleosegunsiradig.this.AV9EmpCod = aP1;
      tieneotroempleosegunsiradig.this.AV10LegNumero = aP2;
      tieneotroempleosegunsiradig.this.AV11LiqPeriodo = aP3;
      tieneotroempleosegunsiradig.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12LegDedConCodigo ;
      GXt_char2 = AV12LegDedConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.otroemplos_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      tieneotroempleosegunsiradig.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      tieneotroempleosegunsiradig.this.GXt_char1 = GXv_char4[0] ;
      AV12LegDedConCodigo = GXt_char1 ;
      /* Using cursor P00W62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV12LegDedConCodigo, AV11LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A84LegDedConCodigo = P00W62_A84LegDedConCodigo[0] ;
         A557LegDedFchHas = P00W62_A557LegDedFchHas[0] ;
         A6LegNumero = P00W62_A6LegNumero[0] ;
         A1EmpCod = P00W62_A1EmpCod[0] ;
         A3CliCod = P00W62_A3CliCod[0] ;
         A83LegDedSec = P00W62_A83LegDedSec[0] ;
         AV13otroEmpleoTiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = tieneotroempleosegunsiradig.this.AV13otroEmpleoTiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegDedConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P00W62_A84LegDedConCodigo = new String[] {""} ;
      P00W62_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      P00W62_A6LegNumero = new int[1] ;
      P00W62_A1EmpCod = new short[1] ;
      P00W62_A3CliCod = new int[1] ;
      P00W62_A83LegDedSec = new int[1] ;
      A84LegDedConCodigo = "" ;
      A557LegDedFchHas = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tieneotroempleosegunsiradig__default(),
         new Object[] {
             new Object[] {
            P00W62_A84LegDedConCodigo, P00W62_A557LegDedFchHas, P00W62_A6LegNumero, P00W62_A1EmpCod, P00W62_A3CliCod, P00W62_A83LegDedSec
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
   private int A83LegDedSec ;
   private String AV12LegDedConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A84LegDedConCodigo ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date A557LegDedFchHas ;
   private boolean AV13otroEmpleoTiene ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00W62_A84LegDedConCodigo ;
   private java.util.Date[] P00W62_A557LegDedFchHas ;
   private int[] P00W62_A6LegNumero ;
   private short[] P00W62_A1EmpCod ;
   private int[] P00W62_A3CliCod ;
   private int[] P00W62_A83LegDedSec ;
}

final  class tieneotroempleosegunsiradig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00W62", "SELECT LegDedConCodigo, LegDedFchHas, LegNumero, EmpCod, CliCod, LegDedSec FROM legajo_deducciones WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegDedConCodigo = ( ?)) AND (LegDedFchHas <= ?) ORDER BY CliCod, EmpCod, LegNumero, LegDedConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

