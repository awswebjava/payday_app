package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obteneropecli extends GXProcedure
{
   public obteneropecli( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obteneropecli.class ), "" );
   }

   public obteneropecli( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              java.util.Date aP2 ,
                              String[] aP3 ,
                              String[] aP4 ,
                              boolean[] aP5 ,
                              String[] aP6 )
   {
      obteneropecli.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        String[] aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             String[] aP6 ,
                             boolean[] aP7 )
   {
      obteneropecli.this.AV8CliCod = aP0;
      obteneropecli.this.AV9OpeCliId = aP1;
      obteneropecli.this.AV16OpeCliVig = aP2;
      obteneropecli.this.aP3 = aP3;
      obteneropecli.this.aP4 = aP4;
      obteneropecli.this.aP5 = aP5;
      obteneropecli.this.aP6 = aP6;
      obteneropecli.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug7(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &OpeCliId ", "")+AV9OpeCliId) ;
      /* Using cursor P00GI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId, AV16OpeCliVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P00GI2_A754OpeCliVig[0] ;
         A82OpeCliId = P00GI2_A82OpeCliId[0] ;
         A3CliCod = P00GI2_A3CliCod[0] ;
         A534OpeCliDescrip = P00GI2_A534OpeCliDescrip[0] ;
         A535OpeCliValor = P00GI2_A535OpeCliValor[0] ;
         A549OpeCliCodFormula = P00GI2_A549OpeCliCodFormula[0] ;
         A534OpeCliDescrip = P00GI2_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P00GI2_A549OpeCliCodFormula[0] ;
         AV11OpeCliDescrip = A534OpeCliDescrip ;
         AV12OpeCliValor = A535OpeCliValor ;
         AV13existe = true ;
         AV14OpeCliCodFormula = A549OpeCliCodFormula ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = obteneropecli.this.AV11OpeCliDescrip;
      this.aP4[0] = obteneropecli.this.AV12OpeCliValor;
      this.aP5[0] = obteneropecli.this.AV17borrarBoolean;
      this.aP6[0] = obteneropecli.this.AV14OpeCliCodFormula;
      this.aP7[0] = obteneropecli.this.AV13existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11OpeCliDescrip = "" ;
      AV12OpeCliValor = "" ;
      AV14OpeCliCodFormula = "" ;
      AV20Pgmname = "" ;
      scmdbuf = "" ;
      P00GI2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P00GI2_A82OpeCliId = new String[] {""} ;
      P00GI2_A3CliCod = new int[1] ;
      P00GI2_A534OpeCliDescrip = new String[] {""} ;
      P00GI2_A535OpeCliValor = new String[] {""} ;
      P00GI2_A549OpeCliCodFormula = new String[] {""} ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      A534OpeCliDescrip = "" ;
      A535OpeCliValor = "" ;
      A549OpeCliCodFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obteneropecli__default(),
         new Object[] {
             new Object[] {
            P00GI2_A754OpeCliVig, P00GI2_A82OpeCliId, P00GI2_A3CliCod, P00GI2_A534OpeCliDescrip, P00GI2_A535OpeCliValor, P00GI2_A549OpeCliCodFormula
            }
         }
      );
      AV20Pgmname = "obtenerOpeCli" ;
      /* GeneXus formulas. */
      AV20Pgmname = "obtenerOpeCli" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String AV14OpeCliCodFormula ;
   private String AV20Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A549OpeCliCodFormula ;
   private java.util.Date AV16OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private boolean AV17borrarBoolean ;
   private boolean AV13existe ;
   private String AV12OpeCliValor ;
   private String A535OpeCliValor ;
   private String AV11OpeCliDescrip ;
   private String A534OpeCliDescrip ;
   private boolean[] aP7 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00GI2_A754OpeCliVig ;
   private String[] P00GI2_A82OpeCliId ;
   private int[] P00GI2_A3CliCod ;
   private String[] P00GI2_A534OpeCliDescrip ;
   private String[] P00GI2_A535OpeCliValor ;
   private String[] P00GI2_A549OpeCliCodFormula ;
}

final  class obteneropecli__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GI2", "SELECT T1.OpeCliVig, T1.OpeCliId, T1.CliCod, T2.OpeCliDescrip, T1.OpeCliValor, T2.OpeCliCodFormula FROM (variable_valores T1 INNER JOIN Variable T2 ON T2.CliCod = T1.CliCod AND T2.OpeCliId = T1.OpeCliId) WHERE T1.CliCod = ? and T1.OpeCliId = ( ?) and T1.OpeCliVig <= ? ORDER BY T1.CliCod, T1.OpeCliId, T1.OpeCliVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

