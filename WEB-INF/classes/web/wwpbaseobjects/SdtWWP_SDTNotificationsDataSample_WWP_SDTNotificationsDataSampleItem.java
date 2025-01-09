package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem extends GxUserType
{
   public SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem( )
   {
      this(  new ModelContext(SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class));
   }

   public SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem( ModelContext context )
   {
      super( context, "SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem");
   }

   public SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem( int remoteHandle ,
                                                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem");
   }

   public SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem( StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "NotificationId") )
            {
               gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NotificationIconClass") )
            {
               gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NotificationTitle") )
            {
               gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NotificationDescription") )
            {
               gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NotificationDatetime") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N = (byte)(0) ;
                  gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "NotificationLink") )
            {
               gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink = oReader.getValue() ;
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
         sName = "WWP_SDTNotificationsDataSample.WWP_SDTNotificationsDataSampleItem" ;
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
      oWriter.writeElement("NotificationId", GXutil.trim( GXutil.str( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid, 5, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("NotificationIconClass", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("NotificationTitle", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("NotificationDescription", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime) && ( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N == 1 ) )
      {
         oWriter.writeElement("NotificationDatetime", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("NotificationDatetime", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("NotificationLink", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink);
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
      AddObjectProperty("NotificationId", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid, false, false);
      AddObjectProperty("NotificationIconClass", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass, false, false);
      AddObjectProperty("NotificationTitle", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle, false, false);
      AddObjectProperty("NotificationDescription", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription, false, false);
      datetime_STZ = gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime ;
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
      AddObjectProperty("NotificationDatetime", sDateCnv, false, false);
      AddObjectProperty("NotificationLink", gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink, false, false);
   }

   public int getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid ;
   }

   public void setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid( int value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid = value ;
   }

   public String getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass ;
   }

   public void setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass = value ;
   }

   public String getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle ;
   }

   public void setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle = value ;
   }

   public String getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription ;
   }

   public void setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription = value ;
   }

   public java.util.Date getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime ;
   }

   public void setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( java.util.Date value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime = value ;
   }

   public String getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink ;
   }

   public void setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink( String value )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(0) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N = (byte)(1) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription = "" ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N = (byte)(1) ;
      gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N ;
   }

   public web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem Clone( )
   {
      return (web.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)(clone()) ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem struct )
   {
      setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid(struct.getNotificationid());
      setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass(struct.getNotificationiconclass());
      setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle(struct.getNotificationtitle());
      setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription(struct.getNotificationdescription());
      if ( struct.gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N == 0 )
      {
         setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime(struct.getNotificationdatetime());
      }
      setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink(struct.getNotificationlink());
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem getStruct( )
   {
      web.wwpbaseobjects.StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem struct = new web.wwpbaseobjects.StructSdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem ();
      struct.setNotificationid(getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid());
      struct.setNotificationiconclass(getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass());
      struct.setNotificationtitle(getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle());
      struct.setNotificationdescription(getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription());
      if ( gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N == 0 )
      {
         struct.setNotificationdatetime(getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime());
      }
      struct.setNotificationlink(getgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink());
      return struct ;
   }

   protected byte gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_N ;
   protected byte gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationid ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime ;
   protected java.util.Date datetime_STZ ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription ;
   protected String gxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationlink ;
}

