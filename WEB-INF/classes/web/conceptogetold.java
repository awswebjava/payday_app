package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptogetold extends GXProcedure
{
   public conceptogetold( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptogetold.class ), "" );
   }

   public conceptogetold( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.Sdtconcepto_old executeUdp( int aP0 ,
                                          String aP1 )
   {
      conceptogetold.this.aP2 = new web.Sdtconcepto_old[] {new web.Sdtconcepto_old()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        web.Sdtconcepto_old[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             web.Sdtconcepto_old[] aP2 )
   {
      conceptogetold.this.AV9CliCod = aP0;
      conceptogetold.this.AV8ConCodigo = aP1;
      conceptogetold.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01X02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01X02_A26ConCodigo[0] ;
         A3CliCod = P01X02_A3CliCod[0] ;
         A1974ConOldValues = P01X02_A1974ConOldValues[0] ;
         AV10concepto_old.fromJSonString(A1974ConOldValues, null);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptogetold.this.AV10concepto_old;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10concepto_old = new web.Sdtconcepto_old(remoteHandle, context);
      scmdbuf = "" ;
      P01X02_A26ConCodigo = new String[] {""} ;
      P01X02_A3CliCod = new int[1] ;
      P01X02_A1974ConOldValues = new String[] {""} ;
      A26ConCodigo = "" ;
      A1974ConOldValues = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptogetold__default(),
         new Object[] {
             new Object[] {
            P01X02_A26ConCodigo, P01X02_A3CliCod, P01X02_A1974ConOldValues
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A1974ConOldValues ;
   private web.Sdtconcepto_old[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01X02_A26ConCodigo ;
   private int[] P01X02_A3CliCod ;
   private String[] P01X02_A1974ConOldValues ;
   private web.Sdtconcepto_old AV10concepto_old ;
}

final  class conceptogetold__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X02", "SELECT ConCodigo, CliCod, ConOldValues FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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

