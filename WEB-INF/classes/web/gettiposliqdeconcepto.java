package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettiposliqdeconcepto extends GXProcedure
{
   public gettiposliqdeconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettiposliqdeconcepto.class ), "" );
   }

   public gettiposliqdeconcepto( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 String aP1 )
   {
      gettiposliqdeconcepto.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      gettiposliqdeconcepto.this.AV10CliCod = aP0;
      gettiposliqdeconcepto.this.AV9ConCodigo = aP1;
      gettiposliqdeconcepto.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P014U2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P014U2_A26ConCodigo[0] ;
         A3CliCod = P014U2_A3CliCod[0] ;
         A32TLiqCod = P014U2_A32TLiqCod[0] ;
         AV8TLiqCod.add(A32TLiqCod, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettiposliqdeconcepto.this.AV8TLiqCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8TLiqCod = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P014U2_A26ConCodigo = new String[] {""} ;
      P014U2_A3CliCod = new int[1] ;
      P014U2_A32TLiqCod = new String[] {""} ;
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettiposliqdeconcepto__default(),
         new Object[] {
             new Object[] {
            P014U2_A26ConCodigo, P014U2_A3CliCod, P014U2_A32TLiqCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A32TLiqCod ;
   private GXSimpleCollection<String>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P014U2_A26ConCodigo ;
   private int[] P014U2_A3CliCod ;
   private String[] P014U2_A32TLiqCod ;
   private GXSimpleCollection<String> AV8TLiqCod ;
}

final  class gettiposliqdeconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014U2", "SELECT ConCodigo, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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

