package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem extends GxUserType
{
   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem( )
   {
      this(  new ModelContext(Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem.class));
   }

   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem( ModelContext context )
   {
      super( context, "Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem");
   }

   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem( int remoteHandle ,
                                                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem");
   }

   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem( StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetImpNum") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConSis") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSigno") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqConExtDescrip") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCantNum") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "esDescuentoDias") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "importacion_sdt.importacion_sdtItem.LegajosItem.DetalleItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("ImpLiqDetImpNum", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetConSis", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetSigno", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqConExtDescrip", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetCantNum", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("esDescuentoDias", GXutil.booltostr( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("ImpLiqDetImpNum", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum, 16, 2)), false, false);
      AddObjectProperty("ImpLiqDetConSis", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis, false, false);
      AddObjectProperty("ImpLiqDetSigno", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno, false, false);
      AddObjectProperty("ImpLiqConExtDescrip", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip, false, false);
      AddObjectProperty("ImpLiqDetCantNum", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum, false, false);
      AddObjectProperty("esDescuentoDias", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum = value ;
   }

   public boolean getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias( boolean value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N ;
   }

   public web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem Clone( )
   {
      return (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem)(clone()) ;
   }

   public void setStruct( web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem struct )
   {
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum(struct.getImpliqdetimpnum());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis(struct.getImpliqdetconsis());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno(struct.getImpliqdetsigno());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip(struct.getImpliqconextdescrip());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum(struct.getImpliqdetcantnum());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias(struct.getEsdescuentodias());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem getStruct( )
   {
      web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem struct = new web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem ();
      struct.setImpliqdetimpnum(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum());
      struct.setImpliqdetconsis(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis());
      struct.setImpliqdetsigno(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno());
      struct.setImpliqconextdescrip(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip());
      struct.setImpliqdetcantnum(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum());
      struct.setEsdescuentodias(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias());
      return struct ;
   }

   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetimpnum ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetcantnum ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetconsis ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqdetsigno ;
   protected String sTagName ;
   protected boolean gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Esdescuentodias ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem_Impliqconextdescrip ;
}

