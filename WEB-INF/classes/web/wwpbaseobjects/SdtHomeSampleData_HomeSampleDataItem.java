package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtHomeSampleData_HomeSampleDataItem extends GxUserType
{
   public SdtHomeSampleData_HomeSampleDataItem( )
   {
      this(  new ModelContext(SdtHomeSampleData_HomeSampleDataItem.class));
   }

   public SdtHomeSampleData_HomeSampleDataItem( ModelContext context )
   {
      super( context, "SdtHomeSampleData_HomeSampleDataItem");
   }

   public SdtHomeSampleData_HomeSampleDataItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtHomeSampleData_HomeSampleDataItem");
   }

   public SdtHomeSampleData_HomeSampleDataItem( StructSdtHomeSampleData_HomeSampleDataItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductName") )
            {
               gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductPrice") )
            {
               gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductWeight") )
            {
               gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductVolume") )
            {
               gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductDiscount") )
            {
               gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProductStatus") )
            {
               gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "HomeSampleData.HomeSampleDataItem" ;
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
      oWriter.writeElement("ProductName", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProductPrice", GXutil.trim( GXutil.strNoRound( gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice, 8, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProductWeight", GXutil.trim( GXutil.strNoRound( gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight, 8, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProductVolume", GXutil.trim( GXutil.strNoRound( gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume, 8, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProductDiscount", GXutil.trim( GXutil.strNoRound( gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount, 5, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProductStatus", GXutil.trim( GXutil.str( gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
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
      AddObjectProperty("ProductName", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname, false, false);
      AddObjectProperty("ProductPrice", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice, false, false);
      AddObjectProperty("ProductWeight", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight, false, false);
      AddObjectProperty("ProductVolume", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume, false, false);
      AddObjectProperty("ProductDiscount", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount, false, false);
      AddObjectProperty("ProductStatus", gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus, false, false);
   }

   public String getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname ;
   }

   public void setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( String value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname = value ;
   }

   public java.math.BigDecimal getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice ;
   }

   public void setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice = value ;
   }

   public java.math.BigDecimal getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight ;
   }

   public void setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight = value ;
   }

   public java.math.BigDecimal getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume ;
   }

   public void setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume = value ;
   }

   public java.math.BigDecimal getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount ;
   }

   public void setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount = value ;
   }

   public byte getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus ;
   }

   public void setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( byte value )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname = "" ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_N = (byte)(1) ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice = DecimalUtil.ZERO ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight = DecimalUtil.ZERO ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume = DecimalUtil.ZERO ;
      gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtHomeSampleData_HomeSampleDataItem_N ;
   }

   public web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem Clone( )
   {
      return (web.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)(clone()) ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtHomeSampleData_HomeSampleDataItem struct )
   {
      setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname(struct.getProductname());
      setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice(struct.getProductprice());
      setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight(struct.getProductweight());
      setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume(struct.getProductvolume());
      setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount(struct.getProductdiscount());
      setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus(struct.getProductstatus());
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtHomeSampleData_HomeSampleDataItem getStruct( )
   {
      web.wwpbaseobjects.StructSdtHomeSampleData_HomeSampleDataItem struct = new web.wwpbaseobjects.StructSdtHomeSampleData_HomeSampleDataItem ();
      struct.setProductname(getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname());
      struct.setProductprice(getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice());
      struct.setProductweight(getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight());
      struct.setProductvolume(getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume());
      struct.setProductdiscount(getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount());
      struct.setProductstatus(getgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus());
      return struct ;
   }

   protected byte gxTv_SdtHomeSampleData_HomeSampleDataItem_N ;
   protected byte gxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtHomeSampleData_HomeSampleDataItem_Productname ;
}

