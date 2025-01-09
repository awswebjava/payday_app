package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getformulaabr extends GXProcedure
{
   public getformulaabr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getformulaabr.class ), "" );
   }

   public getformulaabr( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getformulaabr.this.aP2 = new String[] {""};
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
      getformulaabr.this.AV10CliCod = aP0;
      getformulaabr.this.AV8concodigo = aP1;
      getformulaabr.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00H42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8concodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00H42_A26ConCodigo[0] ;
         A3CliCod = P00H42_A3CliCod[0] ;
         A148ConFormula = P00H42_A148ConFormula[0] ;
         n148ConFormula = P00H42_n148ConFormula[0] ;
         if ( (GXutil.strcmp("", GXutil.trim( A148ConFormula))==0) && ! new web.esredondeoosobregiro(remoteHandle, context).executeUdp( A3CliCod, A26ConCodigo) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV9ConFormula = "" ;
         }
         else
         {
            if ( GXutil.len( GXutil.trim( A148ConFormula)) <= 60 )
            {
               AV9ConFormula = GXutil.trim( A148ConFormula) ;
            }
            else
            {
               AV9ConFormula = GXutil.substring( A148ConFormula, 1, 57) + "..." ;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getformulaabr.this.AV9ConFormula;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConFormula = "" ;
      scmdbuf = "" ;
      P00H42_A26ConCodigo = new String[] {""} ;
      P00H42_A3CliCod = new int[1] ;
      P00H42_A148ConFormula = new String[] {""} ;
      P00H42_n148ConFormula = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getformulaabr__default(),
         new Object[] {
             new Object[] {
            P00H42_A26ConCodigo, P00H42_A3CliCod, P00H42_A148ConFormula, P00H42_n148ConFormula
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8concodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean n148ConFormula ;
   private boolean Cond_result ;
   private String AV9ConFormula ;
   private String A148ConFormula ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00H42_A26ConCodigo ;
   private int[] P00H42_A3CliCod ;
   private String[] P00H42_A148ConFormula ;
   private boolean[] P00H42_n148ConFormula ;
}

final  class getformulaabr__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00H42", "SELECT ConCodigo, CliCod, ConFormula FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
