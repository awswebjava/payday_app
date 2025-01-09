package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptobaseconfpresant extends GXProcedure
{
   public getconceptobaseconfpresant( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptobaseconfpresant.class ), "" );
   }

   public getconceptobaseconfpresant( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           byte[] aP2 )
   {
      getconceptobaseconfpresant.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             byte[] aP3 )
   {
      getconceptobaseconfpresant.this.AV8CliCod = aP0;
      getconceptobaseconfpresant.this.AV9ConCodigo = aP1;
      getconceptobaseconfpresant.this.aP2 = aP2;
      getconceptobaseconfpresant.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01NO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01NO2_A26ConCodigo[0] ;
         A3CliCod = P01NO2_A3CliCod[0] ;
         A1801ConBaseAnt = P01NO2_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P01NO2_A1800ConBasePres[0] ;
         AV14ConBaseAnt = A1801ConBaseAnt ;
         AV13ConBasePres = A1800ConBasePres ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptobaseconfpresant.this.AV14ConBaseAnt;
      this.aP3[0] = getconceptobaseconfpresant.this.AV13ConBasePres;
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
      P01NO2_A26ConCodigo = new String[] {""} ;
      P01NO2_A3CliCod = new int[1] ;
      P01NO2_A1801ConBaseAnt = new byte[1] ;
      P01NO2_A1800ConBasePres = new byte[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptobaseconfpresant__default(),
         new Object[] {
             new Object[] {
            P01NO2_A26ConCodigo, P01NO2_A3CliCod, P01NO2_A1801ConBaseAnt, P01NO2_A1800ConBasePres
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14ConBaseAnt ;
   private byte AV13ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1800ConBasePres ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private byte[] aP3 ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01NO2_A26ConCodigo ;
   private int[] P01NO2_A3CliCod ;
   private byte[] P01NO2_A1801ConBaseAnt ;
   private byte[] P01NO2_A1800ConBasePres ;
}

final  class getconceptobaseconfpresant__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NO2", "SELECT ConCodigo, CliCod, ConBaseAnt, ConBasePres FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

