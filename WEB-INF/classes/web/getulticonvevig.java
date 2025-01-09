package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getulticonvevig extends GXProcedure
{
   public getulticonvevig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getulticonvevig.class ), "" );
   }

   public getulticonvevig( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     String aP2 ,
                                     java.util.Date aP3 )
   {
      getulticonvevig.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date[] aP4 )
   {
      getulticonvevig.this.AV10CliCod = aP0;
      getulticonvevig.this.AV11CliPaiConve = aP1;
      getulticonvevig.this.AV8CliConvenio = aP2;
      getulticonvevig.this.AV12LiqPeriodo = aP3;
      getulticonvevig.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl1 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV12LiqPeriodo ,
                                           A1575CliConveVig ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11CliPaiConve) ,
                                           AV8CliConvenio ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01XF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11CliPaiConve), AV8CliConvenio, AV12LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01XF2_A3CliCod[0] ;
         A1564CliPaiConve = P01XF2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01XF2_A1565CliConvenio[0] ;
         A1575CliConveVig = P01XF2_A1575CliConveVig[0] ;
         AV15GXLvl1 = (byte)(1) ;
         AV9CliConveVig = A1575CliConveVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl1 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliPaiConve: ", "")+GXutil.trim( GXutil.str( AV11CliPaiConve, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliConvenio: ", "")+GXutil.trim( AV8CliConvenio)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&LiqPeriodo: ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&CliConveVig: ", "")+GXutil.trim( localUtil.dtoc( AV9CliConveVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getulticonvevig.this.AV9CliConveVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9CliConveVig = GXutil.nullDate() ;
      scmdbuf = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1565CliConvenio = "" ;
      P01XF2_A3CliCod = new int[1] ;
      P01XF2_A1564CliPaiConve = new short[1] ;
      P01XF2_A1565CliConvenio = new String[] {""} ;
      P01XF2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      AV16Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getulticonvevig__default(),
         new Object[] {
             new Object[] {
            P01XF2_A3CliCod, P01XF2_A1564CliPaiConve, P01XF2_A1565CliConvenio, P01XF2_A1575CliConveVig
            }
         }
      );
      AV16Pgmname = "getUltiConveVig" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getUltiConveVig" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl1 ;
   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String AV16Pgmname ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date AV9CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01XF2_A3CliCod ;
   private short[] P01XF2_A1564CliPaiConve ;
   private String[] P01XF2_A1565CliConvenio ;
   private java.util.Date[] P01XF2_A1575CliConveVig ;
}

final  class getulticonvevig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01XF2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV12LiqPeriodo ,
                                          java.util.Date A1575CliConveVig ,
                                          int AV10CliCod ,
                                          short AV11CliPaiConve ,
                                          String AV8CliConvenio ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV12LiqPeriodo)) )
      {
         addWhere(sWhereString, "(CliConveVig <= ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig DESC" ;
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
                  return conditional_P01XF2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XF2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
      }
   }

}

