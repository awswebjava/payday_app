package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclicodigo extends GXProcedure
{
   public getopeclicodigo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclicodigo.class ), "" );
   }

   public getopeclicodigo( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 )
   {
      getopeclicodigo.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 ,
                             String[] aP4 )
   {
      getopeclicodigo.this.AV8CliCod = aP0;
      getopeclicodigo.this.AV9constantes_default = aP1;
      getopeclicodigo.this.AV10mayusculas = aP2;
      getopeclicodigo.this.AV12sinCorchetes = aP3;
      getopeclicodigo.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11OpeCliIdMay = GXutil.upper( GXutil.trim( AV9constantes_default)) ;
      GXv_char1[0] = AV11OpeCliIdMay ;
      new web.replacefinalconequis(remoteHandle, context).execute( GXv_char1) ;
      getopeclicodigo.this.AV11OpeCliIdMay = GXv_char1[0] ;
      GXv_char1[0] = AV11OpeCliIdMay ;
      new web.removercorchetes(remoteHandle, context).execute( GXv_char1) ;
      getopeclicodigo.this.AV11OpeCliIdMay = GXv_char1[0] ;
      /* Using cursor P00GG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV11OpeCliIdMay});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A536OpeCliIdMay = P00GG2_A536OpeCliIdMay[0] ;
         A3CliCod = P00GG2_A3CliCod[0] ;
         A549OpeCliCodFormula = P00GG2_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P00GG2_A82OpeCliId[0] ;
         AV14OpeCliCodFormulaAux = A549OpeCliCodFormula ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV10mayusculas )
      {
         AV15OpeCliCodFormula = GXutil.trim( GXutil.upper( AV14OpeCliCodFormulaAux)) ;
      }
      else
      {
         AV15OpeCliCodFormula = GXutil.trim( AV14OpeCliCodFormulaAux) ;
      }
      if ( AV12sinCorchetes )
      {
         if ( GXutil.strSearch( AV15OpeCliCodFormula, httpContext.getMessage( " X]", ""), 1) != 0 )
         {
            AV15OpeCliCodFormula = GXutil.strReplace( AV15OpeCliCodFormula, httpContext.getMessage( "X]", ""), "") ;
         }
         AV15OpeCliCodFormula = GXutil.strReplace( AV15OpeCliCodFormula, "[", "") ;
         AV15OpeCliCodFormula = GXutil.strReplace( AV15OpeCliCodFormula, "]", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getopeclicodigo.this.AV15OpeCliCodFormula;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15OpeCliCodFormula = "" ;
      AV11OpeCliIdMay = "" ;
      GXv_char1 = new String[1] ;
      scmdbuf = "" ;
      P00GG2_A536OpeCliIdMay = new String[] {""} ;
      P00GG2_A3CliCod = new int[1] ;
      P00GG2_A549OpeCliCodFormula = new String[] {""} ;
      P00GG2_A82OpeCliId = new String[] {""} ;
      A536OpeCliIdMay = "" ;
      A549OpeCliCodFormula = "" ;
      A82OpeCliId = "" ;
      AV14OpeCliCodFormulaAux = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopeclicodigo__default(),
         new Object[] {
             new Object[] {
            P00GG2_A536OpeCliIdMay, P00GG2_A3CliCod, P00GG2_A549OpeCliCodFormula, P00GG2_A82OpeCliId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9constantes_default ;
   private String AV15OpeCliCodFormula ;
   private String AV11OpeCliIdMay ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A536OpeCliIdMay ;
   private String A549OpeCliCodFormula ;
   private String A82OpeCliId ;
   private String AV14OpeCliCodFormulaAux ;
   private boolean AV10mayusculas ;
   private boolean AV12sinCorchetes ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00GG2_A536OpeCliIdMay ;
   private int[] P00GG2_A3CliCod ;
   private String[] P00GG2_A549OpeCliCodFormula ;
   private String[] P00GG2_A82OpeCliId ;
}

final  class getopeclicodigo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GG2", "SELECT OpeCliIdMay, CliCod, OpeCliCodFormula, OpeCliId FROM Variable WHERE CliCod = ? and OpeCliIdMay = ( ?) ORDER BY CliCod, OpeCliIdMay  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

