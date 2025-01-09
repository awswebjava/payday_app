package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptogetdescri2 extends GXProcedure
{
   public conceptogetdescri2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptogetdescri2.class ), "" );
   }

   public conceptogetdescri2( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      conceptogetdescri2.this.aP3 = new boolean[] {false};
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
      conceptogetdescri2.this.AV8CliCod = aP0;
      conceptogetdescri2.this.AV9ConCodigo = aP1;
      conceptogetdescri2.this.aP2 = aP2;
      conceptogetdescri2.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14GXLvl1 = (byte)(0) ;
      /* Using cursor P00IN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00IN2_A26ConCodigo[0] ;
         A3CliCod = P00IN2_A3CliCod[0] ;
         A41ConDescrip = P00IN2_A41ConDescrip[0] ;
         AV14GXLvl1 = (byte)(1) ;
         AV10ConDescrip = A41ConDescrip ;
         AV11existe = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "ConDescrip ", "")+A41ConDescrip) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV14GXLvl1 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "none ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+" \""+AV9ConCodigo+"\"") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "consigue  ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+" \""+AV9ConCodigo+"\""+" \""+AV10ConDescrip+"\"") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptogetdescri2.this.AV10ConDescrip;
      this.aP3[0] = conceptogetdescri2.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConDescrip = "" ;
      scmdbuf = "" ;
      P00IN2_A26ConCodigo = new String[] {""} ;
      P00IN2_A3CliCod = new int[1] ;
      P00IN2_A41ConDescrip = new String[] {""} ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      AV15Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptogetdescri2__default(),
         new Object[] {
             new Object[] {
            P00IN2_A26ConCodigo, P00IN2_A3CliCod, P00IN2_A41ConDescrip
            }
         }
      );
      AV15Pgmname = "ConceptoGetDescri2" ;
      /* GeneXus formulas. */
      AV15Pgmname = "ConceptoGetDescri2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14GXLvl1 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV15Pgmname ;
   private boolean AV11existe ;
   private String AV10ConDescrip ;
   private String A41ConDescrip ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00IN2_A26ConCodigo ;
   private int[] P00IN2_A3CliCod ;
   private String[] P00IN2_A41ConDescrip ;
}

final  class conceptogetdescri2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IN2", "SELECT ConCodigo, CliCod, ConDescrip FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

