package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptobaseconf extends GXProcedure
{
   public getconceptobaseconf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptobaseconf.class ), "" );
   }

   public getconceptobaseconf( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 ,
                           byte[] aP2 ,
                           byte[] aP3 ,
                           byte[] aP4 )
   {
      getconceptobaseconf.this.aP5 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        byte[] aP3 ,
                        byte[] aP4 ,
                        byte[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             byte[] aP3 ,
                             byte[] aP4 ,
                             byte[] aP5 )
   {
      getconceptobaseconf.this.AV8CliCod = aP0;
      getconceptobaseconf.this.AV9ConCodigo = aP1;
      getconceptobaseconf.this.aP2 = aP2;
      getconceptobaseconf.this.aP3 = aP3;
      getconceptobaseconf.this.aP4 = aP4;
      getconceptobaseconf.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01L22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01L22_A26ConCodigo[0] ;
         A3CliCod = P01L22_A3CliCod[0] ;
         A1621ConBaseFer = P01L22_A1621ConBaseFer[0] ;
         A1622ConBaseHorExt = P01L22_A1622ConBaseHorExt[0] ;
         A1620ConBaseLic = P01L22_A1620ConBaseLic[0] ;
         A2191ConBaseAus = P01L22_A2191ConBaseAus[0] ;
         AV10ConBaseFer = A1621ConBaseFer ;
         AV11ConBaseHorExt = A1622ConBaseHorExt ;
         AV12ConBaseLic = A1620ConBaseLic ;
         AV13ConBaseAus = A2191ConBaseAus ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptobaseconf.this.AV12ConBaseLic;
      this.aP3[0] = getconceptobaseconf.this.AV10ConBaseFer;
      this.aP4[0] = getconceptobaseconf.this.AV11ConBaseHorExt;
      this.aP5[0] = getconceptobaseconf.this.AV13ConBaseAus;
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
      P01L22_A26ConCodigo = new String[] {""} ;
      P01L22_A3CliCod = new int[1] ;
      P01L22_A1621ConBaseFer = new byte[1] ;
      P01L22_A1622ConBaseHorExt = new byte[1] ;
      P01L22_A1620ConBaseLic = new byte[1] ;
      P01L22_A2191ConBaseAus = new byte[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptobaseconf__default(),
         new Object[] {
             new Object[] {
            P01L22_A26ConCodigo, P01L22_A3CliCod, P01L22_A1621ConBaseFer, P01L22_A1622ConBaseHorExt, P01L22_A1620ConBaseLic, P01L22_A2191ConBaseAus
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12ConBaseLic ;
   private byte AV10ConBaseFer ;
   private byte AV11ConBaseHorExt ;
   private byte AV13ConBaseAus ;
   private byte A1621ConBaseFer ;
   private byte A1622ConBaseHorExt ;
   private byte A1620ConBaseLic ;
   private byte A2191ConBaseAus ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private byte[] aP5 ;
   private byte[] aP2 ;
   private byte[] aP3 ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01L22_A26ConCodigo ;
   private int[] P01L22_A3CliCod ;
   private byte[] P01L22_A1621ConBaseFer ;
   private byte[] P01L22_A1622ConBaseHorExt ;
   private byte[] P01L22_A1620ConBaseLic ;
   private byte[] P01L22_A2191ConBaseAus ;
}

final  class getconceptobaseconf__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01L22", "SELECT ConCodigo, CliCod, ConBaseFer, ConBaseHorExt, ConBaseLic, ConBaseAus FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
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

