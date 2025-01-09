package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtHomeSampleNameValueData_HomeSampleNameValueDataItem extends GxUserType
{
   public SdtHomeSampleNameValueData_HomeSampleNameValueDataItem( )
   {
      this(  new ModelContext(SdtHomeSampleNameValueData_HomeSampleNameValueDataItem.class));
   }

   public SdtHomeSampleNameValueData_HomeSampleNameValueDataItem( ModelContext context )
   {
      super( context, "SdtHomeSampleNameValueData_HomeSampleNameValueDataItem");
   }

   public SdtHomeSampleNameValueData_HomeSampleNameValueDataItem( int remoteHandle ,
                                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtHomeSampleNameValueData_HomeSampleNameValueDataItem");
   }

   public SdtHomeSampleNameValueData_HomeSampleNameValueDataItem( StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Check") )
            {
               gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "HomeSampleNameValueData.HomeSampleNameValueDataItem" ;
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
      oWriter.writeElement("Name", gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Value", GXutil.trim( GXutil.strNoRound( gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value, 8, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Check", GXutil.booltostr( gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check));
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
      AddObjectProperty("Name", gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name, false, false);
      AddObjectProperty("Value", gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value, false, false);
      AddObjectProperty("Check", gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check, false, false);
   }

   public String getgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name ;
   }

   public void setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name( String value )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name = value ;
   }

   public java.math.BigDecimal getgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value ;
   }

   public void setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value( java.math.BigDecimal value )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value = value ;
   }

   public boolean getgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check ;
   }

   public void setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check( boolean value )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(0) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name = "" ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N = (byte)(1) ;
      gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N ;
   }

   public web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem Clone( )
   {
      return (web.wwpbaseobjects.SdtHomeSampleNameValueData_HomeSampleNameValueDataItem)(clone()) ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem struct )
   {
      setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name(struct.getName());
      setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value(struct.getValue());
      setgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check(struct.getCheck());
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem getStruct( )
   {
      web.wwpbaseobjects.StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem struct = new web.wwpbaseobjects.StructSdtHomeSampleNameValueData_HomeSampleNameValueDataItem ();
      struct.setName(getgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name());
      struct.setValue(getgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value());
      struct.setCheck(getgxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check());
      return struct ;
   }

   protected byte gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Value ;
   protected String sTagName ;
   protected boolean gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Check ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtHomeSampleNameValueData_HomeSampleNameValueDataItem_Name ;
}

