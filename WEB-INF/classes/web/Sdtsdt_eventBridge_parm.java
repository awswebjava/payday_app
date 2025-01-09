package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_eventBridge_parm extends GxUserType
{
   public Sdtsdt_eventBridge_parm( )
   {
      this(  new ModelContext(Sdtsdt_eventBridge_parm.class));
   }

   public Sdtsdt_eventBridge_parm( ModelContext context )
   {
      super( context, "Sdtsdt_eventBridge_parm");
   }

   public Sdtsdt_eventBridge_parm( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_eventBridge_parm");
   }

   public Sdtsdt_eventBridge_parm( StructSdtsdt_eventBridge_parm struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "version") )
            {
               gxTv_Sdtsdt_eventBridge_parm_Version = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "id") )
            {
               gxTv_Sdtsdt_eventBridge_parm_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "source") )
            {
               gxTv_Sdtsdt_eventBridge_parm_Source = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "account") )
            {
               gxTv_Sdtsdt_eventBridge_parm_Account = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "time") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_eventBridge_parm_Time = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_Sdtsdt_eventBridge_parm_Time_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_eventBridge_parm_Time_N = (byte)(0) ;
                  gxTv_Sdtsdt_eventBridge_parm_Time = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "region") )
            {
               gxTv_Sdtsdt_eventBridge_parm_Region = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detail") )
            {
               gxTv_Sdtsdt_eventBridge_parm_Detail = oReader.getValue() ;
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
         sName = "sdt_eventBridge_parm" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("version", gxTv_Sdtsdt_eventBridge_parm_Version);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("id", gxTv_Sdtsdt_eventBridge_parm_Id);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("source", gxTv_Sdtsdt_eventBridge_parm_Source);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("account", gxTv_Sdtsdt_eventBridge_parm_Account);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_Sdtsdt_eventBridge_parm_Time) && ( gxTv_Sdtsdt_eventBridge_parm_Time_N == 1 ) )
      {
         oWriter.writeElement("time", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_eventBridge_parm_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_eventBridge_parm_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_eventBridge_parm_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtsdt_eventBridge_parm_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtsdt_eventBridge_parm_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtsdt_eventBridge_parm_Time), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("time", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("region", gxTv_Sdtsdt_eventBridge_parm_Region);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("detail", gxTv_Sdtsdt_eventBridge_parm_Detail);
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
      AddObjectProperty("version", gxTv_Sdtsdt_eventBridge_parm_Version, false, false);
      AddObjectProperty("id", gxTv_Sdtsdt_eventBridge_parm_Id, false, false);
      AddObjectProperty("source", gxTv_Sdtsdt_eventBridge_parm_Source, false, false);
      AddObjectProperty("account", gxTv_Sdtsdt_eventBridge_parm_Account, false, false);
      datetime_STZ = gxTv_Sdtsdt_eventBridge_parm_Time ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("time", sDateCnv, false, false);
      AddObjectProperty("region", gxTv_Sdtsdt_eventBridge_parm_Region, false, false);
      AddObjectProperty("detail", gxTv_Sdtsdt_eventBridge_parm_Detail, false, false);
   }

   public String getgxTv_Sdtsdt_eventBridge_parm_Version( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Version ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Version( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Version = value ;
   }

   public String getgxTv_Sdtsdt_eventBridge_parm_Id( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Id ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Id( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Id = value ;
   }

   public String getgxTv_Sdtsdt_eventBridge_parm_Source( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Source ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Source( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Source = value ;
   }

   public String getgxTv_Sdtsdt_eventBridge_parm_Account( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Account ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Account( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Account = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_eventBridge_parm_Time( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Time ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Time( java.util.Date value )
   {
      gxTv_Sdtsdt_eventBridge_parm_Time_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Time = value ;
   }

   public String getgxTv_Sdtsdt_eventBridge_parm_Region( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Region ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Region( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Region = value ;
   }

   public String getgxTv_Sdtsdt_eventBridge_parm_Detail( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_Detail ;
   }

   public void setgxTv_Sdtsdt_eventBridge_parm_Detail( String value )
   {
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_eventBridge_parm_Detail = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_eventBridge_parm_Version = "" ;
      gxTv_Sdtsdt_eventBridge_parm_N = (byte)(1) ;
      gxTv_Sdtsdt_eventBridge_parm_Id = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Source = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Account = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Time = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtsdt_eventBridge_parm_Time_N = (byte)(1) ;
      gxTv_Sdtsdt_eventBridge_parm_Region = "" ;
      gxTv_Sdtsdt_eventBridge_parm_Detail = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_eventBridge_parm_N ;
   }

   public web.Sdtsdt_eventBridge_parm Clone( )
   {
      return (web.Sdtsdt_eventBridge_parm)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_eventBridge_parm struct )
   {
      setgxTv_Sdtsdt_eventBridge_parm_Version(struct.getVersion());
      setgxTv_Sdtsdt_eventBridge_parm_Id(struct.getId());
      setgxTv_Sdtsdt_eventBridge_parm_Source(struct.getSource());
      setgxTv_Sdtsdt_eventBridge_parm_Account(struct.getAccount());
      if ( struct.gxTv_Sdtsdt_eventBridge_parm_Time_N == 0 )
      {
         setgxTv_Sdtsdt_eventBridge_parm_Time(struct.getTime());
      }
      setgxTv_Sdtsdt_eventBridge_parm_Region(struct.getRegion());
      setgxTv_Sdtsdt_eventBridge_parm_Detail(struct.getDetail());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_eventBridge_parm getStruct( )
   {
      web.StructSdtsdt_eventBridge_parm struct = new web.StructSdtsdt_eventBridge_parm ();
      struct.setVersion(getgxTv_Sdtsdt_eventBridge_parm_Version());
      struct.setId(getgxTv_Sdtsdt_eventBridge_parm_Id());
      struct.setSource(getgxTv_Sdtsdt_eventBridge_parm_Source());
      struct.setAccount(getgxTv_Sdtsdt_eventBridge_parm_Account());
      if ( gxTv_Sdtsdt_eventBridge_parm_Time_N == 0 )
      {
         struct.setTime(getgxTv_Sdtsdt_eventBridge_parm_Time());
      }
      struct.setRegion(getgxTv_Sdtsdt_eventBridge_parm_Region());
      struct.setDetail(getgxTv_Sdtsdt_eventBridge_parm_Detail());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_eventBridge_parm_N ;
   protected byte gxTv_Sdtsdt_eventBridge_parm_Time_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_eventBridge_parm_Time ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Detail ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Version ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Id ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Source ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Account ;
   protected String gxTv_Sdtsdt_eventBridge_parm_Region ;
}

