package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenioadicionalexiste extends GXProcedure
{
   public convenioadicionalexiste( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenioadicionalexiste.class ), "" );
   }

   public convenioadicionalexiste( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              String aP3 )
   {
      convenioadicionalexiste.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      convenioadicionalexiste.this.AV12CliCod = aP0;
      convenioadicionalexiste.this.AV11CliPaiConve = aP1;
      convenioadicionalexiste.this.AV10CliConvenio = aP2;
      convenioadicionalexiste.this.AV8ConveAdicod = aP3;
      convenioadicionalexiste.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV10CliConvenio ,
                                           A1565CliConvenio ,
                                           A996ConveAdicod ,
                                           AV8ConveAdicod ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Short.valueOf(AV11CliPaiConve) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P020A2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11CliPaiConve), AV8ConveAdicod, AV10CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A996ConveAdicod = P020A2_A996ConveAdicod[0] ;
         A1565CliConvenio = P020A2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P020A2_A1564CliPaiConve[0] ;
         A3CliCod = P020A2_A3CliCod[0] ;
         AV9existe = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliPaiConve: ", "")+GXutil.trim( GXutil.str( AV11CliPaiConve, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliConvenio: ", "")+GXutil.trim( AV10CliConvenio)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&ConveAdicod: ", "")+GXutil.trim( AV8ConveAdicod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&existe: ", "")+GXutil.trim( GXutil.booltostr( AV9existe))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = convenioadicionalexiste.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      P020A2_A996ConveAdicod = new String[] {""} ;
      P020A2_A1565CliConvenio = new String[] {""} ;
      P020A2_A1564CliPaiConve = new short[1] ;
      P020A2_A3CliCod = new int[1] ;
      AV16Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenioadicionalexiste__default(),
         new Object[] {
             new Object[] {
            P020A2_A996ConveAdicod, P020A2_A1565CliConvenio, P020A2_A1564CliPaiConve, P020A2_A3CliCod
            }
         }
      );
      AV16Pgmname = "convenioAdicionalExiste" ;
      /* GeneXus formulas. */
      AV16Pgmname = "convenioAdicionalExiste" ;
      Gx_err = (short)(0) ;
   }

   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV8ConveAdicod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String AV16Pgmname ;
   private boolean AV9existe ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P020A2_A996ConveAdicod ;
   private String[] P020A2_A1565CliConvenio ;
   private short[] P020A2_A1564CliPaiConve ;
   private int[] P020A2_A3CliCod ;
}

final  class convenioadicionalexiste__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P020A2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV10CliConvenio ,
                                          String A1565CliConvenio ,
                                          String A996ConveAdicod ,
                                          String AV8ConveAdicod ,
                                          int AV12CliCod ,
                                          short AV11CliPaiConve ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ConveAdicod, CliConvenio, CliPaiConve, CliCod FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ?)");
      addWhere(sWhereString, "(ConveAdicod = ( ?))");
      if ( ! (GXutil.strcmp("", AV10CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P020A2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020A2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

