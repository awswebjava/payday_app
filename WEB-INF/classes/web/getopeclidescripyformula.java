package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclidescripyformula extends GXProcedure
{
   public getopeclidescripyformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclidescripyformula.class ), "" );
   }

   public getopeclidescripyformula( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getopeclidescripyformula.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      getopeclidescripyformula.this.AV9CliCod = aP0;
      getopeclidescripyformula.this.AV10OpeCliId = aP1;
      getopeclidescripyformula.this.aP2 = aP2;
      getopeclidescripyformula.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01TJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01TJ2_A82OpeCliId[0] ;
         A3CliCod = P01TJ2_A3CliCod[0] ;
         A534OpeCliDescrip = P01TJ2_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P01TJ2_A549OpeCliCodFormula[0] ;
         AV8OpeCliDescrip = A534OpeCliDescrip ;
         AV11OpeCliCodFormula = A549OpeCliCodFormula ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getopeclidescripyformula.this.AV8OpeCliDescrip;
      this.aP3[0] = getopeclidescripyformula.this.AV11OpeCliCodFormula;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OpeCliDescrip = "" ;
      AV11OpeCliCodFormula = "" ;
      scmdbuf = "" ;
      P01TJ2_A82OpeCliId = new String[] {""} ;
      P01TJ2_A3CliCod = new int[1] ;
      P01TJ2_A534OpeCliDescrip = new String[] {""} ;
      P01TJ2_A549OpeCliCodFormula = new String[] {""} ;
      A82OpeCliId = "" ;
      A534OpeCliDescrip = "" ;
      A549OpeCliCodFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopeclidescripyformula__default(),
         new Object[] {
             new Object[] {
            P01TJ2_A82OpeCliId, P01TJ2_A3CliCod, P01TJ2_A534OpeCliDescrip, P01TJ2_A549OpeCliCodFormula
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10OpeCliId ;
   private String AV11OpeCliCodFormula ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private String AV8OpeCliDescrip ;
   private String A534OpeCliDescrip ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01TJ2_A82OpeCliId ;
   private int[] P01TJ2_A3CliCod ;
   private String[] P01TJ2_A534OpeCliDescrip ;
   private String[] P01TJ2_A549OpeCliCodFormula ;
}

final  class getopeclidescripyformula__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TJ2", "SELECT OpeCliId, CliCod, OpeCliDescrip, OpeCliCodFormula FROM Variable WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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

