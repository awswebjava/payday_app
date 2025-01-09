package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoafipgettildeaposipa extends GXProcedure
{
   public conceptoafipgettildeaposipa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoafipgettildeaposipa.class ), "" );
   }

   public conceptoafipgettildeaposipa( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      conceptoafipgettildeaposipa.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      conceptoafipgettildeaposipa.this.AV8CliCod = aP0;
      conceptoafipgettildeaposipa.this.AV9ConCodPropio = aP1;
      conceptoafipgettildeaposipa.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &ConCodPropio ", "")+GXutil.trim( AV9ConCodPropio)) ;
      /* Using cursor P00HS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodPropio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A73ConCodPropio = P00HS2_A73ConCodPropio[0] ;
         A3CliCod = P00HS2_A3CliCod[0] ;
         A141ConAFIPSIPAApo = P00HS2_A141ConAFIPSIPAApo[0] ;
         AV10ConAFIPSIPAApo = A141ConAFIPSIPAApo ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "ConAFIPSIPAApo ", "")+A141ConAFIPSIPAApo) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&ConAFIPSIPAApo ", "")+AV10ConAFIPSIPAApo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptoafipgettildeaposipa.this.AV10ConAFIPSIPAApo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConAFIPSIPAApo = "" ;
      AV13Pgmname = "" ;
      scmdbuf = "" ;
      P00HS2_A73ConCodPropio = new String[] {""} ;
      P00HS2_A3CliCod = new int[1] ;
      P00HS2_A141ConAFIPSIPAApo = new String[] {""} ;
      A73ConCodPropio = "" ;
      A141ConAFIPSIPAApo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoafipgettildeaposipa__default(),
         new Object[] {
             new Object[] {
            P00HS2_A73ConCodPropio, P00HS2_A3CliCod, P00HS2_A141ConAFIPSIPAApo
            }
         }
      );
      AV13Pgmname = "ConceptoAfipGetTildeApoSIPA" ;
      /* GeneXus formulas. */
      AV13Pgmname = "ConceptoAfipGetTildeApoSIPA" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodPropio ;
   private String AV10ConAFIPSIPAApo ;
   private String AV13Pgmname ;
   private String scmdbuf ;
   private String A73ConCodPropio ;
   private String A141ConAFIPSIPAApo ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00HS2_A73ConCodPropio ;
   private int[] P00HS2_A3CliCod ;
   private String[] P00HS2_A141ConAFIPSIPAApo ;
}

final  class conceptoafipgettildeaposipa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00HS2", "SELECT ConCodPropio, CliCod, ConAFIPSIPAApo FROM ConceptoAFIP WHERE CliCod = ? and ConCodPropio = ( ?) ORDER BY CliCod, ConCodPropio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

