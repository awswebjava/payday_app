package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptopordesc extends GXProcedure
{
   public getconceptopordesc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptopordesc.class ), "" );
   }

   public getconceptopordesc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getconceptopordesc.this.aP2 = new String[] {""};
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
      getconceptopordesc.this.AV8CliCod = aP0;
      getconceptopordesc.this.AV9ConDescrip = aP1;
      getconceptopordesc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00GM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A41ConDescrip = P00GM2_A41ConDescrip[0] ;
         A3CliCod = P00GM2_A3CliCod[0] ;
         A26ConCodigo = P00GM2_A26ConCodigo[0] ;
         AV10ConCodigo = A26ConCodigo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptopordesc.this.AV10ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodigo = "" ;
      scmdbuf = "" ;
      P00GM2_A41ConDescrip = new String[] {""} ;
      P00GM2_A3CliCod = new int[1] ;
      P00GM2_A26ConCodigo = new String[] {""} ;
      A41ConDescrip = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptopordesc__default(),
         new Object[] {
             new Object[] {
            P00GM2_A41ConDescrip, P00GM2_A3CliCod, P00GM2_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV9ConDescrip ;
   private String A41ConDescrip ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00GM2_A41ConDescrip ;
   private int[] P00GM2_A3CliCod ;
   private String[] P00GM2_A26ConCodigo ;
}

final  class getconceptopordesc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GM2", "SELECT ConDescrip, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (RTRIM(LTRIM(LOWER(ConDescrip))) = ( RTRIM(LTRIM(LOWER(?))))) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
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
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

