package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptobaseosdif extends GXProcedure
{
   public getconceptobaseosdif( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptobaseosdif.class ), "" );
   }

   public getconceptobaseosdif( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           String aP1 )
   {
      getconceptobaseosdif.this.aP2 = new byte[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        byte[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             byte[] aP2 )
   {
      getconceptobaseosdif.this.AV8CliCod = aP0;
      getconceptobaseosdif.this.AV10ConCodigo = aP1;
      getconceptobaseosdif.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01PT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV10ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01PT2_A26ConCodigo[0] ;
         A3CliCod = P01PT2_A3CliCod[0] ;
         A1827ConBaseOSDif = P01PT2_A1827ConBaseOSDif[0] ;
         AV9ConBaseOSDif = A1827ConBaseOSDif ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptobaseosdif.this.AV9ConBaseOSDif;
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
      P01PT2_A26ConCodigo = new String[] {""} ;
      P01PT2_A3CliCod = new int[1] ;
      P01PT2_A1827ConBaseOSDif = new byte[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptobaseosdif__default(),
         new Object[] {
             new Object[] {
            P01PT2_A26ConCodigo, P01PT2_A3CliCod, P01PT2_A1827ConBaseOSDif
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9ConBaseOSDif ;
   private byte A1827ConBaseOSDif ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01PT2_A26ConCodigo ;
   private int[] P01PT2_A3CliCod ;
   private byte[] P01PT2_A1827ConBaseOSDif ;
}

final  class getconceptobaseosdif__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PT2", "SELECT ConCodigo, CliCod, ConBaseOSDif FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

