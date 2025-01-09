package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqfrecpagmodtraytarifa extends GXProcedure
{
   public getliqfrecpagmodtraytarifa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqfrecpagmodtraytarifa.class ), "" );
   }

   public getliqfrecpagmodtraytarifa( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte[] aP3 ,
                        String[] aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 ,
                             String[] aP4 ,
                             String aP5 )
   {
      getliqfrecpagmodtraytarifa.this.AV11CliCod = aP0;
      getliqfrecpagmodtraytarifa.this.AV10EmpCod = aP1;
      getliqfrecpagmodtraytarifa.this.AV9LiqNro = aP2;
      getliqfrecpagmodtraytarifa.this.aP3 = aP3;
      getliqfrecpagmodtraytarifa.this.aP4 = aP4;
      getliqfrecpagmodtraytarifa.this.AV15LiqTipoTarifa = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02L82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02L82_A31LiqNro[0] ;
         A1EmpCod = P02L82_A1EmpCod[0] ;
         A3CliCod = P02L82_A3CliCod[0] ;
         A2414LiqFrecPag = P02L82_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P02L82_A2409LiqModTra[0] ;
         A2426LiqTipoTarifa = P02L82_A2426LiqTipoTarifa[0] ;
         AV14LiqFrecPag = A2414LiqFrecPag ;
         AV13LiqModTra = A2409LiqModTra ;
         AV15LiqTipoTarifa = A2426LiqTipoTarifa ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqfrecpagmodtraytarifa.this.AV14LiqFrecPag;
      this.aP4[0] = getliqfrecpagmodtraytarifa.this.AV13LiqModTra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LiqModTra = "" ;
      scmdbuf = "" ;
      P02L82_A31LiqNro = new int[1] ;
      P02L82_A1EmpCod = new short[1] ;
      P02L82_A3CliCod = new int[1] ;
      P02L82_A2414LiqFrecPag = new byte[1] ;
      P02L82_A2409LiqModTra = new String[] {""} ;
      P02L82_A2426LiqTipoTarifa = new String[] {""} ;
      A2409LiqModTra = "" ;
      A2426LiqTipoTarifa = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqfrecpagmodtraytarifa__default(),
         new Object[] {
             new Object[] {
            P02L82_A31LiqNro, P02L82_A1EmpCod, P02L82_A3CliCod, P02L82_A2414LiqFrecPag, P02L82_A2409LiqModTra, P02L82_A2426LiqTipoTarifa
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqFrecPag ;
   private byte A2414LiqFrecPag ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV13LiqModTra ;
   private String AV15LiqTipoTarifa ;
   private String scmdbuf ;
   private String A2409LiqModTra ;
   private String A2426LiqTipoTarifa ;
   private byte[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02L82_A31LiqNro ;
   private short[] P02L82_A1EmpCod ;
   private int[] P02L82_A3CliCod ;
   private byte[] P02L82_A2414LiqFrecPag ;
   private String[] P02L82_A2409LiqModTra ;
   private String[] P02L82_A2426LiqTipoTarifa ;
}

final  class getliqfrecpagmodtraytarifa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L82", "SELECT LiqNro, EmpCod, CliCod, LiqFrecPag, LiqModTra, LiqTipoTarifa FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
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

