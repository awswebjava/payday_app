package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliqdepalabra extends GXProcedure
{
   public gettipoliqdepalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliqdepalabra.class ), "" );
   }

   public gettipoliqdepalabra( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      gettipoliqdepalabra.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      gettipoliqdepalabra.this.AV9CliCod = aP0;
      gettipoliqdepalabra.this.AV10TLiqCodFor = aP1;
      gettipoliqdepalabra.this.aP2 = aP2;
      gettipoliqdepalabra.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ZN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10TLiqCodFor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2091TLiqCodFor = P01ZN2_A2091TLiqCodFor[0] ;
         A3CliCod = P01ZN2_A3CliCod[0] ;
         A32TLiqCod = P01ZN2_A32TLiqCod[0] ;
         AV8TLiqCod = A32TLiqCod ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( false )
      {
         new web.pendientesdeoptimizarcasesensitive(remoteHandle, context).execute( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettipoliqdepalabra.this.AV8TLiqCod;
      this.aP3[0] = gettipoliqdepalabra.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8TLiqCod = "" ;
      scmdbuf = "" ;
      P01ZN2_A2091TLiqCodFor = new String[] {""} ;
      P01ZN2_A3CliCod = new int[1] ;
      P01ZN2_A32TLiqCod = new String[] {""} ;
      A2091TLiqCodFor = "" ;
      A32TLiqCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliqdepalabra__default(),
         new Object[] {
             new Object[] {
            P01ZN2_A2091TLiqCodFor, P01ZN2_A3CliCod, P01ZN2_A32TLiqCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10TLiqCodFor ;
   private String AV8TLiqCod ;
   private String scmdbuf ;
   private String A2091TLiqCodFor ;
   private String A32TLiqCod ;
   private boolean AV11existe ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZN2_A2091TLiqCodFor ;
   private int[] P01ZN2_A3CliCod ;
   private String[] P01ZN2_A32TLiqCod ;
}

final  class gettipoliqdepalabra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZN2", "SELECT TLiqCodFor, CliCod, TLiqCod FROM TipoLiquidacion WHERE (CliCod = ?) AND (UPPER(RTRIM(LTRIM(TLiqCodFor))) = ( RTRIM(LTRIM(UPPER(?))))) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

