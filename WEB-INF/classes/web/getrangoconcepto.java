package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrangoconcepto extends GXProcedure
{
   public getrangoconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrangoconcepto.class ), "" );
   }

   public getrangoconcepto( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Short> executeUdp( int aP0 ,
                                                String aP1 )
   {
      getrangoconcepto.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<Short>(Short.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXSimpleCollection<Short>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXSimpleCollection<Short>[] aP2 )
   {
      getrangoconcepto.this.AV11CliCod = aP0;
      getrangoconcepto.this.AV8ConCodigo = aP1;
      getrangoconcepto.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P014V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P014V2_A26ConCodigo[0] ;
         A3CliCod = P014V2_A3CliCod[0] ;
         A1018ConRangoCant = P014V2_A1018ConRangoCant[0] ;
         if ( ! (GXutil.strcmp("", A1018ConRangoCant)==0) )
         {
            AV10rangoNumeros.fromJSonString(A1018ConRangoCant, null);
         }
         else
         {
            AV10rangoNumeros.add((short)(1), 0);
            AV10rangoNumeros.add((short)(999), 0);
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getrangoconcepto.this.AV10rangoNumeros;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10rangoNumeros = new GXSimpleCollection<Short>(Short.class, "internal", "");
      scmdbuf = "" ;
      P014V2_A26ConCodigo = new String[] {""} ;
      P014V2_A3CliCod = new int[1] ;
      P014V2_A1018ConRangoCant = new String[] {""} ;
      A26ConCodigo = "" ;
      A1018ConRangoCant = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrangoconcepto__default(),
         new Object[] {
             new Object[] {
            P014V2_A26ConCodigo, P014V2_A3CliCod, P014V2_A1018ConRangoCant
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A1018ConRangoCant ;
   private GXSimpleCollection<Short> AV10rangoNumeros ;
   private GXSimpleCollection<Short>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P014V2_A26ConCodigo ;
   private int[] P014V2_A3CliCod ;
   private String[] P014V2_A1018ConRangoCant ;
}

final  class getrangoconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014V2", "SELECT ConCodigo, CliCod, ConRangoCant FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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

